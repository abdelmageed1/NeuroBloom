package com.example.mente.Autism.Specialist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mente.Autism.Data.QuestionsSpecialist.DataQChat10
import com.example.mente.Autism.Models.QChat10Model
import com.example.mente.R
import com.example.mente.databinding.FragmentQchat10Binding


class Qchat10Fragment : Fragment() {

    lateinit var binding: FragmentQchat10Binding
    lateinit var arrQuestion: MutableList<QChat10Model>
    private var indexCurrentQuestion = 0
    private var listAns = mutableListOf<Int>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arrQuestion = DataQChat10.QChat10Data

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this){
            performAction()
        }
        callback.isEnabled = true

        setHasOptionsMenu(true)
    }


    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // Perform the desired action when the back button is pressed
                performAction()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun performAction() {
        findNavController().navigate(R.id.action_qchat10Fragment_to_parentAutismFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQchat10Binding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setQuestionInView()
        setBtnNext()
    }




    private fun setBtnNext() {
        binding.radioGroupQChat10.setOnCheckedChangeListener { _, optionId ->
            run {

                var ans = 0
                var isChecked = true

                if (indexCurrentQuestion in 0..8) {
                    when (optionId) {
                        R.id.rbQChat10Select1 -> ans = 0
                        R.id.rbQChat10Select2 -> ans = 0
                        R.id.rbQChat10Select3 -> ans = 1
                        R.id.rbQChat10Select4 -> ans = 1
                        R.id.rbQChat10Select5 -> ans = 1
                        else -> isChecked = false
                    }

                }
                if (indexCurrentQuestion == 9) {
                    when (optionId) {
                        R.id.rbQChat10Select1 -> ans = 1
                        R.id.rbQChat10Select2 -> ans = 1
                        R.id.rbQChat10Select3 -> ans = 1
                        R.id.rbQChat10Select4 -> ans = 0
                        R.id.rbQChat10Select5 -> ans = 0
                        else -> isChecked = false
                    }
                }

                if (isChecked) {
//                    totalPoint += ans
//
                    setDegree(ans)

                    indexCurrentQuestion++


                    if (indexCurrentQuestion < arrQuestion.size) {
                        // go to next question
                        setQuestionInView()
                    } else {
                        questionsListAns.addAll(0,listAns)
                        AutismResultFragment.modelInput = questionsListAns
//                        Toast.makeText(context, "$questionsListAns", Toast.LENGTH_LONG).show()
                        findNavController().navigate(R.id.action_qchat10Fragment_to_autismResultFragment)
                    }
                }
            }
        }
    }

    private fun setDegree(ans: Int) {
        listAns.add(ans)
    }

    private fun setQuestionInView() {
        updateProgressBar()
        if (indexCurrentQuestion < arrQuestion.size) {
            binding.tvQTitleQChat10.text = arrQuestion[indexCurrentQuestion].strQ
            binding.rbQChat10Select1.text = arrQuestion[indexCurrentQuestion].ans1
            binding.rbQChat10Select2.text = arrQuestion[indexCurrentQuestion].ans2
            binding.rbQChat10Select3.text = arrQuestion[indexCurrentQuestion].ans3
            binding.rbQChat10Select4.text = arrQuestion[indexCurrentQuestion].ans4
            binding.rbQChat10Select5.text = arrQuestion[indexCurrentQuestion].ans5

            binding.radioGroupQChat10.clearCheck()

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()

        binding.progressBar.progress = 0
        binding.progressBar.max = 0

    }


    private fun updateProgressBar() {
        binding.progressBar.progress = indexCurrentQuestion
        binding.progressBar.max = arrQuestion.size

    }

    companion object {
        var questionsListAns = mutableListOf<Int>()
    }
}