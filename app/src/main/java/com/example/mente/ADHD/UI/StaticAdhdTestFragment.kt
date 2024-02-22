package com.example.mente.ADHD.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mente.ADHD.Data.AdhdData
import com.example.mente.R
import com.example.mente.Student.Model.Student
import com.example.mente.databinding.FragmentStaticAdhdTestBinding

class StaticAdhdTestFragment : Fragment() {

    private lateinit var binding : FragmentStaticAdhdTestBinding
    private var indexCurrentQuestion = 0
    private var totalPoints = 0
    private lateinit var arrQuestions: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arrQuestions = AdhdData.AdhdData
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStaticAdhdTestBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getSelection()
        setQuestionInView()
    }


    private fun getSelection(){
        binding.radioGroupStaticAdhd.setOnCheckedChangeListener { _, id ->
            run {

                var ans = 0
                var isChecked = true
                when(id){
                    R.id.rbQSAdhdSelect1 -> ans = 0
                    R.id.rbQSAdhdSelect2 -> ans = 1
                    R.id.rbQSAdhdSelect3 -> ans = 2
                    R.id.rbSAdhdSelect4 -> ans = 3
                    else -> isChecked = false
                }


                if (isChecked) {
                    totalPoints += ans
                    indexCurrentQuestion++

                    if (indexCurrentQuestion < arrQuestions.size) {
                        // go to next question
                        setQuestionInView()
                    }
                    else
                    {
                        StaticAdhdResultFragment.testResult = totalPoints
                        findNavController().navigate(R.id.action_staticAdhdTestFragment_to_staticAdhdResultFragment)

                    }
                }
            }
        }
    }

    private fun setQuestionInView() {
        updateProgressBar()
        if (indexCurrentQuestion < arrQuestions.size){

            binding.tvQAdhd.text = arrQuestions[indexCurrentQuestion]
            binding.radioGroupStaticAdhd.clearCheck()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()

        binding.progressBar.progress = 0
        binding.progressBar.max = 0

    }


    private fun updateProgressBar() {
        binding.progressBar.progress = indexCurrentQuestion+1
        binding.progressBar.max = arrQuestions.size

        binding.textInProgress.text= "${indexCurrentQuestion+1}/${arrQuestions.size}"

    }


    companion object {
        lateinit var categoryQuestion: String
        lateinit var student: Student

    }
}