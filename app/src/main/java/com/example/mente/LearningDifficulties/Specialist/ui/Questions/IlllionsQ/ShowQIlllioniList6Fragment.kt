package com.example.mente.Specialist.ui.Questions.IlllionsQ

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mente.Data.QuestionsSpecialist.neuralIllinois.DataNeuralIllinois
import com.example.mente.Models.Question
import com.example.mente.R
import com.example.mente.Specialist.ui.Questions.Evaluation.EvaluationSpeElIIinoiFragment
import com.example.mente.Student.Model.Student
import com.example.mente.databinding.FragmentShowQIlllioniList6Binding

class ShowQIlllioniList6Fragment : Fragment() {
    lateinit var binding: FragmentShowQIlllioniList6Binding
    private var ans: Int = 0
    private var totalPoint = 0
    private var indexCurrentQuestion = 0
    lateinit var arrQuestion: MutableList<Question>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         arrQuestion = DataNeuralIllinois.IllinoisDataList6




    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowQIlllioniList6Binding.inflate(inflater, container, false)

       binding.pickerIllioni6.minValue = 0
        binding.pickerIllioni6.maxValue = 10

        binding.pickerIllioni6.orientation = LinearLayout.HORIZONTAL

        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setQuestionInView()

        binding.pickerIllioni6.setOnValueChangedListener { numberPicker, i, i2 ->
            ans = i2
        }



        setBtnNext()
    }
    private fun setQuestionInView() {
        updateProgressBar()
        if (indexCurrentQuestion < arrQuestion.size) {

//            binding.tvQTitleShowIllioni6.text = arrQuestion[indexCurrentQuestion].strQuestion
            binding.tvQTitleShowIllioni6.visibility = View.GONE

            binding.img1ShowIllioni6.setImageResource(arrQuestion[indexCurrentQuestion].img1)

          binding.pickerIllioni6.value = 0


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

    private fun setBtnNext() {

        binding.btnNext.setOnClickListener {

             totalPoint += ans

            indexCurrentQuestion++
                if (indexCurrentQuestion in 0 until arrQuestion.size
                ) {
                    // go to next question

                    setQuestionInView()


                } else {

                    goToEvaluationPage()
                }
            }


        }


    private fun goToEvaluationPage() {
        findNavController().navigate(R.id.action_showQIlllioniList6Fragment_to_evaluationSpeNeuralFragment)
        EvaluationSpeElIIinoiFragment.testName = categoryQuestion
        EvaluationSpeElIIinoiFragment.scoredValue = totalPoint
        EvaluationSpeElIIinoiFragment.numberOfQuestions = arrQuestion.size
        //EvaluationSpeNeuralFragment.numberOfQuestions = arrQuestion.size
    }
    companion object {
        lateinit var categoryQuestion: String
        lateinit var student: Student
    }
}