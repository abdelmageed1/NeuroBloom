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
import com.example.mente.Autism.Data.QuestionsSpecialist.GilamData.Companion.GilamAutismFactor
import com.example.mente.Autism.Data.QuestionsSpecialist.GilamData.Companion.GilamGetStandardDegree1
import com.example.mente.Autism.Data.QuestionsSpecialist.GilamData.Companion.GilamGetStandardDegree2
import com.example.mente.Autism.Data.QuestionsSpecialist.GilamData.Companion.GilamGetStandardDegree3
import com.example.mente.Autism.Data.QuestionsSpecialist.GilamData.Companion.GilamGetStandardDegree4
import com.example.mente.Autism.Models.GilamModel
import com.example.mente.Models.Quiz
import com.example.mente.R
import com.example.mente.Specialist.ui.Questions.Evaluation.EvaluationMichealBest
import com.example.mente.Student.Model.Student
import com.example.mente.Student.StudentViewModel.StudentViewModel
import com.example.mente.constant
import com.example.mente.databinding.FragmentGilamResultBinding
import java.text.SimpleDateFormat
import java.util.Calendar


class GilamResultFragment : Fragment() {

    lateinit var binding: FragmentGilamResultBinding
    private lateinit var studentViewModel: StudentViewModel
    private var degreeOfTest1 = 0
    private var degreeOfTest2 = 0
    private var degreeOfTest3 = 0
    private var degreeOfTest4 = 0
    private var percentOfTest1 = ""
    private var percentOfTest2 = ""
    private var percentOfTest3 = ""
    private var percentOfTest4 = ""
    private var fourTestDegree = 0
    private var autismFactorDegree = 0
    private var autismFactorPercent = ""
    private var testResult = ""





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        studentViewModel = ViewModelProvider(this)[StudentViewModel::class.java]

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this){
            findNavController().navigate(R.id.action_gilamResultFragment_to_homeAutismFragment)
        }
        callback.isEnabled = true

//        Toast.makeText(context, "${GilamData.GilamGetStandardDegree1[1..1]!!.degree}", Toast.LENGTH_SHORT).show()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGilamResultBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        degreeOfTest1 = getGilamStandardDegree1(test1)!!.degree
        percentOfTest1 = getGilamStandardDegree1(test1)!!.percent

        degreeOfTest2 = getGilamStandardDegree2(test2)!!.degree
        percentOfTest2 = getGilamStandardDegree2(test2)!!.percent

        degreeOfTest3 = getGilamStandardDegree3(test3)!!.degree
        percentOfTest3 = getGilamStandardDegree3(test3)!!.percent

        degreeOfTest4 = getGilamStandardDegree4(test4)!!.degree
        percentOfTest4 = getGilamStandardDegree4(test4)!!.percent

        fourTestDegree = degreeOfTest1 + degreeOfTest2 + degreeOfTest3 + degreeOfTest4

        autismFactorDegree = GilamAutismFactor[fourTestDegree]!!.degree
        autismFactorPercent = GilamAutismFactor[fourTestDegree]!!.percent


        testResult = when(autismFactorDegree){
            in 69..69 -> "منخفض جداً"
            in 70..79 -> "منخفض"
            in 80..89 -> "دون المتوسط"
            in 90..110 -> "متوسط"
            in 111..120 -> "فوق المتوسط"
            in 121..130 -> "مرتفع"
            else -> "مرتفع جداً"
        }


        binding.gilamResultText1.text = "الدرجة الكلية : $totalPoints"
        binding.gilamResultText2.text = "بند السلوكيات النمطية -> \n" +
                "الدرجة الخام : $test1\n" +
                "الدرجة المعيارية : $degreeOfTest1\n" +
                "النسبة المئوية : $percentOfTest1"

        binding.gilamResultText3.text = "بند التواصل -> \n" +
                "الدرجة الخام : $test2\n" +
                "الدرجة المعيارية : $degreeOfTest2\n" +
                "النسبة المئوية : $percentOfTest2"

        binding.gilamResultText4.text = "بند التفاعل الاجتماعي -> \n" +
                "الدرجة الخام : $test3\n" +
                "الدرجة المعيارية : $degreeOfTest3\n" +
                "النسبة المئوية : $percentOfTest3"

        binding.gilamResultText5.text = "بند اضطرابات النمو -> \n" +
                "الدرجة الخام : $test4\n" +
                "الدرجة المعيارية : $degreeOfTest4\n" +
                "النسبة المئوية : $percentOfTest4"


        binding.gilamResultText6.text = "مجموع أربع ابعاد فرعية : $fourTestDegree"

        binding.gilamResultText7.text =   "معامل التوحد : $autismFactorDegree"
        binding.gilamResultText8.text =    "النسبة المئوية لمعامل التوحد : $autismFactorPercent"
        binding.gilamResultText9.text =     "احتمال وجود التوجد : $testResult"


////        binding.gilamResultText.text = "الدرجة الكلية : $totalPoints\n" +
////                "الدرجة الخام السلوكيات النمطية :$test1\n" +
////                "الدرجة الخام التواصل : $test2\n" +
////                "الدرجة الخام التفاعل الاجتماعي : $test3\n" +
////                "الدرجة الخام اضطرابات النمو : $test4 \n" +
////                "الدرجة المعيارية السلوكيات النمطية : $degreeOfTest1\n" +
////                "الدرجة المعيارية التواصل :$degreeOfTest2\n" +
////                "الدرجة المعيارية التفاعل الاجتماعي :$degreeOfTest3 \n" +
////                "الدرجة المعيارية اضطرابات النمو :$degreeOfTest4\n" +
////                "النسبة المئوية السلوكيات النمطية :$percentOfTest1\n" +
////                "النسبة المئوية التواصل :$percentOfTest2\n"+
////                "النسبة المئوية التفاعل الاجتماعي :$percentOfTest3\n"+
////                "النسبة المئوية اضطرابات النمو : $percentOfTest4\n" +
//                        "مجموع أربع ابعاد فرعية : $fourTestDegree\n" +
//                "معامل التوحد : $autismFactorDegree\n" +
//                "النسبة المئوية لمعامل التوحد : $autismFactorPercent\n" +
//                "احتمال وجود التوجد : $testResult"


        binding.goHomeButton.setOnClickListener {
            findNavController().navigate(R.id.action_gilamResultFragment_to_homeAutismFragment)
        }

        binding.addTestResult.setOnClickListener {
           addValueToStudent("بند السلوكيات النمطية",  degreeOfTest1.toString())
           addValueToStudent("بند التواصل", degreeOfTest2.toString())
           addValueToStudent("بند التفاعل الاجتماعي",  degreeOfTest3.toString())
           addValueToStudent("بند اضطرابات النمو",  degreeOfTest4.toString())

        }
    }


    private fun addValueToStudent(testName:String, valueOfQuiz: String) {

        var quiz = Quiz(mainTest = constant.quizTypeAutism,testName,constant.quizTypgilam,
            valueOfQuiz.toString(),valueOfQuiz.toString(),getCurrentDate(),getCurrentTime())
        studentViewModel.setQuizValue(quiz, currentStudent)

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

    private fun getGilamStandardDegree1(number: Int): GilamModel? {
        for (intRange in GilamGetStandardDegree1.keys) {
            if (number in intRange) {
                return GilamGetStandardDegree1[intRange]?.degree?.let { GilamGetStandardDegree1[intRange]?.percent?.let { it1 ->
                    GilamModel(it,
                        it1
                    )
                } }
            }
        }
        return null
    }


    private fun getGilamStandardDegree2(number: Int): GilamModel? {
        for (intRange in GilamGetStandardDegree2.keys) {
            if (number in intRange) {
                return GilamGetStandardDegree2[intRange]?.degree?.let { GilamGetStandardDegree2[intRange]?.percent?.let { it1 ->
                    GilamModel(it,
                        it1
                    )
                } }
            }
        }
        return null
    }


    private fun getGilamStandardDegree3(number: Int): GilamModel? {
        for (intRange in GilamGetStandardDegree3.keys) {
            if (number in intRange) {
                return GilamGetStandardDegree3[intRange]?.degree?.let { GilamGetStandardDegree3[intRange]?.percent?.let { it1 ->
                    GilamModel(it,
                        it1
                    )
                } }
            }
        }
        return null
    }



    private fun getGilamStandardDegree4(number: Int): GilamModel? {
        for (intRange in GilamGetStandardDegree4.keys) {
            if (number in intRange) {
                return GilamGetStandardDegree4[intRange]?.degree?.let { GilamGetStandardDegree4[intRange]?.percent?.let { it1 ->
                    GilamModel(it,
                        it1
                    )
                } }
            }
        }
        return null
    }


    companion object {
        lateinit var currentStudent: Student
        var totalPoints = 0
        var test1 = 0
        var test2 = 0
        var test3 = 0
        var test4 = 0


    }
}