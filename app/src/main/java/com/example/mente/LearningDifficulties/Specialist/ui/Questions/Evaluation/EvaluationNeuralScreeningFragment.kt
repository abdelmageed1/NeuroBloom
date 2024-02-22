package com.example.mente.Specialist.ui.Questions.Evaluation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mente.Models.Quiz
import com.example.mente.R
import com.example.mente.Student.Model.Student
import com.example.mente.Student.StudentViewModel.StudentViewModel
import com.example.mente.constant
import com.example.mente.databinding.FragmentEvaluationNeuralScreeningBinding
import java.text.SimpleDateFormat
import java.util.*


class EvaluationNeuralScreeningFragment : Fragment() {

    lateinit var binding: FragmentEvaluationNeuralScreeningBinding
    private lateinit var studentViewModel: StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        studentViewModel = ViewModelProvider(this)[StudentViewModel::class.java]
     }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentEvaluationNeuralScreeningBinding.inflate(inflater, container, false)

//        binding.tvOfEvaluation.text = """
//            الدرجة الكلية : $totalPoint
//              ﻣﮭﺎرة اﻟﯾد : $test1
//            اﻟﺗﻌرف ﻋﻠﻰ ﺷﻛل و ﻧﺳﺧﮫ : $test2
//            اﻟﺗﻌرف ﻋﻠﻰ اﻟﺷﻛل ﺣﯾن ﯾرﺳم ﺑﺎﻟﻣس ﻋﻠﻰ راﺣﺔ اﻟﯾد : $test3
//             ﻣﺗﺎﺑﻌﺔ ﺷﯾﺊ ﻣﺗﺣرك ﺑﺎﻟﻌﯾن : $test4
//            محاكاة الاصوات : $test5
//            ﻟﻣس اﻷﻧف ﺑﺎﻷﺻﺑﻊ  : $test6
//            ﻋﻣل داﺋرة ﺑﺈﺻﺑﻊ اﻹﺑﮭﺎم و ﺑﻘﯾﺔ اﻷﺻﺎﺑﻊ : $test7
//            ﻟﻣس اﻟﯾد و اﻟﺧد ﻓﻰ ﻧﻔس اﻟوﻗت : $test8
//            اﻟﺣرﻛﺎت اﻟﺳرﯾﻌﺔ اﻟﻣﺗﻛررة و اﻟﻌﻛﺳﯾﺔ ﻟﻠﯾدﯾن : $test9
//             ﻓرد اﻟذراﻋﯾن و اﻟرﺟﻠﯾن : $test10
//            اﻟﻣﺷﻰ اﻟﺗﺑﺎدﻟﻰ  : $test11
//            اﻟوﻗوف ﻋﻠﻰ رﺟل واﺣدة : $test12
//            اﻟوﺛب ﻋﻠﻰ ﻗدم واﺣدة اﻟﺣﺟل :$test13
//            اﻟﺗﻣﯾﯾز ﺑﯾن اﻟﯾﺳﺎر و اﻟﯾﻣﯾن : $test14
//            أﻧﻣﺎط اﻟﺳﻠوك اﻟﺷﺎذ : $test15
//
//        """.trimIndent()

        binding.test1.text = test1.toString()
        binding.test2.text = test2.toString()
        binding.test3.text = test3.toString()
        binding.test4.text = test4.toString()
        binding.test5.text = test5.toString()
        binding.test6.text = test6.toString()
        binding.test7.text = test7.toString()
        binding.test8.text = test8.toString()
        binding.test9.text = test9.toString()
        binding.test10.text = test10.toString()
        binding.test11.text = test11.toString()
        binding.test12.text = test12.toString()
        binding.test13.text = test13.toString()
        binding.test14.text = test14.toString()
        binding.test15.text = test15.toString()

        binding.testTotal.text = totalPoint.toString()


        return binding.root



    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddValueToStudent.setOnClickListener {
            addValueToStudent(constant.neuralCategoryList[0] ,  String.format("%.2f", test1 ))
            addValueToStudent(constant.neuralCategoryList[1] ,  String.format("%.2f", test2))
            addValueToStudent(constant.neuralCategoryList[2] , String.format("%.2f", test3 ))
            addValueToStudent(constant.neuralCategoryList[3] ,  String.format("%.2f", test4 ) )
            addValueToStudent(constant.neuralCategoryList[4] ,  String.format("%.2f", test5 ) )
            addValueToStudent(constant.neuralCategoryList[5] ,  String.format("%.2f", test6 ) )
            addValueToStudent(constant.neuralCategoryList[6] ,  String.format("%.2f", test7 ) )
            addValueToStudent(constant.neuralCategoryList[7] ,  String.format("%.2f", test8 ) )
            addValueToStudent(constant.neuralCategoryList[8] ,  String.format("%.2f", test9 ) )
            addValueToStudent(constant.neuralCategoryList[9] ,  String.format("%.2f", test10 ) )
            addValueToStudent(constant.neuralCategoryList[10] ,  String.format("%.2f", test11 ) )
            addValueToStudent(constant.neuralCategoryList[11] ,  String.format("%.2f", test12 ) )
            addValueToStudent(constant.neuralCategoryList[12] ,  String.format("%.2f", test13 ) )
            addValueToStudent(constant.neuralCategoryList[13] ,  String.format("%.2f", test14 ) )
            addValueToStudent(constant.neuralCategoryList[14] ,  String.format("%.2f", test15 ) )
        }


        binding.btnGoToHome.setOnClickListener {

            findNavController().navigate(R.id.action_evaluationNeuralScreeningFragment_to_homeFragment)
        }
    }

    private fun addValueToStudent(testName:String, valueOfQuiz: String) {

        var quiz = Quiz(mainTest = constant.quizTypeDiff,testName,constant.quizTypeSpeNeural,valueOfQuiz.toString(),valueOfQuiz.toString(),getCurrentDate(),getCurrentTime())
        studentViewModel.setQuizValue(quiz,  currentStudent)

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

    companion object {
        lateinit var currentStudent: Student
        var totalPoint = 0.0f
        var test1 = 0.0f
        var test2 = 0.0f
        var test3 = 0.0f
        var test4 = 0.0f
        var test5 = 0.0f
        var test6 = 0.0f
        var test7 = 0.0f
        var test8 = 0.0f
        var test9 = 0.0f
        var test10 = 0.0f
        var test11 = 0.0f
        var test12 = 0.0f
        var test13 = 0.0f
        var test14 = 0.0f
        var test15 = 0.0f

    }
}