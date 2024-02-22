package com.example.mente.Autism.Specialist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mente.Models.Quiz
import com.example.mente.R
import com.example.mente.RecomendationFragment
import com.example.mente.Specialist.ui.Questions.Evaluation.EvaluationMichealBest
import com.example.mente.Student.Model.Student
import com.example.mente.Student.StudentViewModel.StudentViewModel
import com.example.mente.constant
import com.example.mente.databinding.FragmentCarsResultBinding
import java.text.SimpleDateFormat
import java.util.Calendar


class CarsResultFragment : Fragment() {
    private lateinit var studentViewModel: StudentViewModel
    private lateinit var binding : FragmentCarsResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCarsResultBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val evaluate = when(result.toInt()){
            in 15..29 -> "ليس توحد"
            in 30..44 -> "توحد بسيط"
            else -> "توحد شديد"
        }

        binding.testResultNum.text = result.toInt().toString()
        binding.carsAutismResultText.text = evaluate
        binding.goHomeButton.setOnClickListener {
            findNavController().navigate(R.id.action_carsResultFragment_to_homeAutismFragment)
        }

        binding.goToRecButton.visibility = if (result.toInt() > 30) View.VISIBLE else View.GONE

        binding.goToRecButton.setOnClickListener {
            RecomendationFragment.testType = "autism"
            findNavController().navigate(R.id.action_carsResultFragment_to_recomendationFragment2)
        }




        binding.btnAddValueToStudent.setOnClickListener {
            addValueToStudent(constant.quizTypecars,  String.format("%.2f", result) )

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        studentViewModel = ViewModelProvider(this)[StudentViewModel::class.java]

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this){
            findNavController().navigate(R.id.action_carsResultFragment_to_homeAutismFragment)
        }
        callback.isEnabled = true
    }


    private fun addValueToStudent(testName:String, valueOfQuiz: String) {

        var quiz = Quiz(mainTest = constant.quizTypeAutism,testName,
            constant.quizTypecars,valueOfQuiz.toString(),valueOfQuiz.toString(),getCurrentDate(),getCurrentTime())
        studentViewModel.setQuizValue(quiz, student)

        studentViewModel.mSetQuizSuccess.observe(viewLifecycleOwner) {
            if (it) {

                binding.btnAddValueToStudent.isEnabled = false
            }

        }
        studentViewModel.mSetQuizFailure.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }

    }



    private fun getCurrentDate(): String {
        val calendar = Calendar.getInstance()
        val simpleDateFormat =
            SimpleDateFormat("MMM dd, yyyy")
        return simpleDateFormat.format(calendar.time)
    }

    private fun getCurrentTime(): String {
        val calendar = Calendar.getInstance()
        val simpleDateFormat = SimpleDateFormat("HH:mm:ss ")
        return simpleDateFormat.format(calendar.time)
    }


    companion object{
         var result  = 0.0
        lateinit var categoryQuestion: String
        lateinit var student: Student
    }


}