package com.example.mente.Specialist.ui.Questions.NeuralScreening

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mente.Data.QuestionsSpecialist.neuralScreening.DataNeural
import com.example.mente.Models.Question
import com.example.mente.R
import com.example.mente.Specialist.ui.Questions.Evaluation.EvaluationNeuralScreeningFragment
import com.example.mente.constant
import com.example.mente.databinding.FragmentNeuralScreeningBinding


class NeuralScreeningFragment : Fragment() {
    lateinit var binding: FragmentNeuralScreeningBinding
    lateinit var arrQuestion: MutableList<Question>
    private var indexCurrentQuestion = 0
    private var totalPoint = 0



   var test1 =0
   var test2 =0
   var test3 =0
   var test4 =0
   var test5 =0
   var test6 =0
   var test7 =0
   var test8 =0
   var test9  =0
   var test10 =0
   var test11 =0
   var test12 =0
   var test13 =0
   var test14 =0
    var test15 =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arrQuestion = DataNeural.neuralDataList
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        binding = FragmentNeuralScreeningBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


         setSubTestName()
        setQuestionInView()
        setBtnNext()


    }

    private fun setSubTestName(){

        when(indexCurrentQuestion){
            in 0..3 -> binding.tvNeuralTeatName.text = constant.neuralCategoryList[0]
            in 4..13 -> binding.tvNeuralTeatName.text = constant.neuralCategoryList[1]
            in 14..22 ->binding.tvNeuralTeatName.text = constant.neuralCategoryList[2]
            in 23..26 -> binding.tvNeuralTeatName.text = constant.neuralCategoryList[3]
            in 27..35 -> binding.tvNeuralTeatName.text = constant.neuralCategoryList[4]
            in 36..41 -> binding.tvNeuralTeatName.text = constant.neuralCategoryList[5]
            in 42..47 -> binding.tvNeuralTeatName.text = constant.neuralCategoryList[6]
            in 48..52 -> binding.tvNeuralTeatName.text = constant.neuralCategoryList[7]
            in 53..57 -> binding.tvNeuralTeatName.text = constant.neuralCategoryList[8]
            in 58..64 -> binding.tvNeuralTeatName.text = constant.neuralCategoryList[9]
            in 65..72 -> binding.tvNeuralTeatName.text = constant.neuralCategoryList[10]
            in 73..76 -> binding.tvNeuralTeatName.text = constant.neuralCategoryList[11]
            in 77..80 -> binding.tvNeuralTeatName.text = constant.neuralCategoryList[12]
            in 81..83 -> binding.tvNeuralTeatName.text = constant.neuralCategoryList[13]


            else -> binding.tvNeuralTeatName.text = constant.neuralCategoryList[14]
        }


    }


    private fun setBtnNext() {
        binding.radioGroupQNeural.setOnCheckedChangeListener { radioGroup, optionId ->
            run {

//            var rbSelected = binding.radioGroupQMicheal.checkedRadioButtonId
                var ans = 0
                var isChecked = true

                when (optionId) {
                    R.id.rbNeuralSelectYes -> ans = arrQuestion[indexCurrentQuestion].rightAns
                    R.id.rbNeuralSelectNo -> ans = 0

                    else -> isChecked = false
                }

                if (isChecked) {
                    totalPoint += ans

                    setDegree(ans)
                    indexCurrentQuestion++


                    if (indexCurrentQuestion < arrQuestion.size) {
                        // go to next question
                        setQuestionInView()


                    }
                    else
                    {
                        findNavController().navigate(R.id.action_neuralScreeningFragment_to_evaluationNeuralScreeningFragment)
                          EvaluationNeuralScreeningFragment.totalPoint = totalPoint/1f
                          EvaluationNeuralScreeningFragment.test1 = test1/1f
                          EvaluationNeuralScreeningFragment.test2 = test2/1f
                          EvaluationNeuralScreeningFragment.test3 = test3/1f
                          EvaluationNeuralScreeningFragment.test4 = test4/1f
                          EvaluationNeuralScreeningFragment.test5 = test5/1f
                          EvaluationNeuralScreeningFragment.test6 = test6/1f
                          EvaluationNeuralScreeningFragment.test7 = test7/1f
                          EvaluationNeuralScreeningFragment.test8 = test8/1f
                          EvaluationNeuralScreeningFragment.test9 = test9/1f
                          EvaluationNeuralScreeningFragment.test10 = test10/1f
                          EvaluationNeuralScreeningFragment.test11 = test11/1f
                          EvaluationNeuralScreeningFragment.test12 = test12/1f
                          EvaluationNeuralScreeningFragment.test13 = test13/1f
                          EvaluationNeuralScreeningFragment.test14 = test14/1f
                          EvaluationNeuralScreeningFragment.test15 = test15/1f





                    }
                }

//            else {
//                Toast.makeText(context, "اختر الاجابات", Toast.LENGTH_SHORT).show()
//
//            }

               // setMainTestName()
                setSubTestName()

            }
        }
    }

    private fun setDegree(ans: Int) {
        when(indexCurrentQuestion)
        {

            in 0..3 ->  {test1 += ans }
            in 4..13 -> {test2 += ans }
            in 14..22 ->{test3 += ans }
            in 23..26 ->{test4 += ans }
            in 27..35 ->{test5 += ans }
            in 36..41 ->{test6 += ans }
            in 42..47 ->{test7 += ans }
            in 48..52 ->{test8 += ans }
            in 53..57 ->{test9 += ans }
            in 58..64 ->{test10+= ans }
            in 65..72 ->{test11+= ans }
            in 73..76 ->{test12+= ans }
            in 77..80 ->{test13+= ans }
            in 81..83 ->{test14+= ans }
            in 84..100 ->{test15 += ans
            }









        }
    }

    private fun setQuestionInView() {
        updateProgressBar()
        if (indexCurrentQuestion < arrQuestion.size)
        {
            binding.tvQTitleNeural.text = arrQuestion[indexCurrentQuestion].strQuestion
            binding.radioGroupQNeural.clearCheck()

        }
    }

    private fun updateProgressBar() {
        binding.progressBar.progress = indexCurrentQuestion+1
        binding.progressBar.max = arrQuestion.size
        binding.textInProgress.text= "${indexCurrentQuestion+1}/${arrQuestion.size}"

    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding.progressBar.progress = 0
        binding.progressBar.max = 0

    }

    companion object {

    }
}