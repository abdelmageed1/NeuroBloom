package com.example.mente.ADHD.UI

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mente.ADHD.Data.MentalHealthData
import com.example.mente.Autism.Specialist.ui.AutismResultFragment.Companion.modelInput
import com.example.mente.R
import com.example.mente.databinding.FragmentMentalHealthTestBinding

 class MentalHealthTestFragment : Fragment() {

    private lateinit var binding: FragmentMentalHealthTestBinding
    private var indexCurrentQuestion = 0
    lateinit var arrQuestion: MutableList<String>


    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this){
            performAction()
        }
        callback.isEnabled = true

        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setHasOptionsMenu(true)
        arrQuestion = MentalHealthData.MentalHealthData

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
       findNavController().navigate(R.id.action_mentalHealthTestFragment_to_parentAdhdFragment)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMentalHealthTestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setQuestionInView()
        onSelect()
    }




    private fun onSelect() {
        binding.radioGroupQTwo.setOnCheckedChangeListener { _, id ->
            run {
                var ans = 0
                var isChecked = true

                when (id) {
                    R.id.rbSelectYesMental -> ans = 1
                    R.id.rbSelectNoMental -> ans = 0
                    else -> isChecked = false
                }


                if (isChecked) {

                    setAnswer(ans)
                    indexCurrentQuestion++
                    if (indexCurrentQuestion < arrQuestion.size) {
                        // go to next question
                        setQuestionInView()
                    } else {
//                        listAnswers.add(0, age)
                        MentalHealthResult.modelInput = listAnswers
//                        Toast.makeText(context, "$listAnswers", Toast.LENGTH_LONG).show()
                        findNavController().navigate(R.id.action_mentalHealthTestFragment_to_mentalHealthResult)
                    }
                }
            }
        }
    }

    private fun setQuestionInView() {
        updateProgressBar()
        if (indexCurrentQuestion < arrQuestion.size) {
            binding.tvQMental.text = arrQuestion[indexCurrentQuestion]
            binding.radioGroupQTwo.clearCheck()
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

    private fun setAnswer(ans: Int) {
        listAnswers.add(ans)
    }

    companion object {
       var listAnswers = mutableListOf<Int>()
    }



}