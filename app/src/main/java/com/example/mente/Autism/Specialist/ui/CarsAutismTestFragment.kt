package com.example.mente.Autism.Specialist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mente.Autism.Data.QuestionsSpecialist.CarsAutismData
import com.example.mente.Autism.Models.CarsAutismModel
import com.example.mente.R
import com.example.mente.Student.Model.Student
import com.example.mente.databinding.FragmentCarsAutismTestBinding


class CarsAutismTestFragment : Fragment() {

    private lateinit var binding : FragmentCarsAutismTestBinding
    lateinit var arrQuestion: MutableList<CarsAutismModel>

    private var indexCurrentQuestion = 0
    private var totalPoint = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arrQuestion = CarsAutismData.Adhd_Questions
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCarsAutismTestBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setQuestionInView()
        setBtnNext()
    }

    private fun setBtnNext() {
        binding.radioGroupCars.setOnCheckedChangeListener { _, optionId ->
            run {

                var ans = 0.0
                var isChecked = true

                when (optionId) {
                    R.id.rbCarsSelect1 -> ans = 0.0
                    R.id.rbCarsSelect2 -> ans = 1.5
                    R.id.rbCarsSelect3 -> ans = 2.5
                    R.id.rbCarsSelect4 -> ans = 3.5
                    else -> isChecked = false
                }

                if (isChecked) {
                    totalPoint += ans

                    indexCurrentQuestion++

                    if (indexCurrentQuestion < arrQuestion.size) {
                        // go to next question
                        setQuestionInView()
                    }
                    else
                    {
                        CarsResultFragment.result = totalPoint
                        findNavController().navigate(R.id.action_carsAutismTestFragment_to_carsResultFragment)
                    }
                }
            }
        }
    }

    private fun setQuestionInView() {
        updateProgressBar()
        if (indexCurrentQuestion < arrQuestion.size)
        {
            binding.tvQCarsAutism.text = arrQuestion[indexCurrentQuestion].strQ
            binding.rbCarsSelect1.text = arrQuestion[indexCurrentQuestion].ans1
            binding.rbCarsSelect2.text = arrQuestion[indexCurrentQuestion].ans2
            binding.rbCarsSelect3.text = arrQuestion[indexCurrentQuestion].ans3
            binding.rbCarsSelect4.text = arrQuestion[indexCurrentQuestion].ans4
            binding.radioGroupCars.clearCheck()


        }
    }


    override fun onDestroyView() {
        super.onDestroyView()

        binding.progressBar.progress = 0
        binding.progressBar.max = 0

    }


    private fun updateProgressBar() {
        binding.progressBar.progress = indexCurrentQuestion+1
        binding.progressBar.max = arrQuestion.size
        binding.textInProgress.text= "${indexCurrentQuestion+1}/${arrQuestion.size}"
    }


    companion object{
        lateinit var categoryQuestion: String
        lateinit var student: Student
    }

}