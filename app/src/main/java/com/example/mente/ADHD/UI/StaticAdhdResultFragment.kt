package com.example.mente.ADHD.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mente.Autism.Specialist.ui.GilamResultFragment
import com.example.mente.Models.Quiz
import com.example.mente.R
import com.example.mente.RecomendationFragment
import com.example.mente.Student.Model.Student
import com.example.mente.Student.StudentViewModel.StudentViewModel
import com.example.mente.constant
import com.example.mente.databinding.FragmentStaticAdhdResultBinding
import java.text.SimpleDateFormat
import java.util.Calendar


class StaticAdhdResultFragment : Fragment() {

    private lateinit var binding : FragmentStaticAdhdResultBinding
    private lateinit var studentViewModel: StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        studentViewModel = ViewModelProvider(this)[StudentViewModel::class.java]

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this){
            findNavController().navigate(R.id.action_staticAdhdResultFragment_to_adhdTestsFragment)
        }
        callback.isEnabled = true

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStaticAdhdResultBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val hasOrNot = when{
           testResult > 83 -> "يعاني الطفل من اعراض فرط الحركة ونقص الانتباه"
            else -> " لا يعاني الطفل من اعراض فرط الحركة ونقص الانتباه"
        }

        binding.testAdhdResultNum.text = testResult.toString()
        binding.staticAdhdResultText.text = hasOrNot
        binding.goHomeButton.setOnClickListener {
            findNavController().navigate(R.id.action_staticAdhdResultFragment_to_adhdTestsFragment)
        }

        binding.goToRecButton.visibility = if (testResult > 83) View.VISIBLE else View.GONE



        binding.goToRecButton.setOnClickListener {
            RecomendationFragment.testType = "adhd"
            findNavController().navigate(R.id.action_staticAdhdResultFragment_to_recomendationFragment)
        }

        binding.addTestResult.setOnClickListener {
            addValueToStudent("فرط الحركة  ",  testResult.toString())


        }



    }



    private fun addValueToStudent(testName:String, valueOfQuiz: String) {

        var quiz = Quiz(mainTest = constant.quizTypeAdhd,testName, constant.quizTypeadhaDR,
            valueOfQuiz.toString(),valueOfQuiz.toString(),getCurrentDate(),getCurrentTime())
        studentViewModel.setQuizValue(quiz,  currentStudent)

        studentViewModel.mSetQuizSuccess.observe(viewLifecycleOwner) {
            if (it) {

                binding.addTestResult.isEnabled = false
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
        var testResult = 0

        lateinit var currentStudent: Student
    }

}