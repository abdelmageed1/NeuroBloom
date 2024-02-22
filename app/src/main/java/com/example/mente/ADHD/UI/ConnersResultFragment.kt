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
import com.example.mente.ADHD.Data.ConnersGetStandardDegree_12_14Female
import com.example.mente.ADHD.Data.ConnersGetStandardDegree_12_14Male
import com.example.mente.ADHD.Data.ConnersGetStandardDegree_15_17Female
import com.example.mente.ADHD.Data.ConnersGetStandardDegree_15_17Male
import com.example.mente.ADHD.Data.ConnersGetStandardDegree_3_5Female
import com.example.mente.ADHD.Data.ConnersGetStandardDegree_3_5Male
import com.example.mente.ADHD.Data.ConnersGetStandardDegree_6_8Female
import com.example.mente.ADHD.Data.ConnersGetStandardDegree_6_8Male
import com.example.mente.ADHD.Data.ConnersGetStandardDegree_9_11Female
import com.example.mente.ADHD.Data.ConnersGetStandardDegree_9_11Male
import com.example.mente.Autism.Specialist.ui.GilamResultFragment
import com.example.mente.Models.Quiz
import com.example.mente.R
import com.example.mente.Student.Model.Student
import com.example.mente.Student.StudentViewModel.StudentViewModel
import com.example.mente.constant
import com.example.mente.databinding.FragmentConnersResultBinding
import java.text.SimpleDateFormat
import java.util.Calendar


class ConnersResultFragment : Fragment() {
    private lateinit var studentViewModel: StudentViewModel

    lateinit var binding: FragmentConnersResultBinding
    private var standardA = 0
    private var standardB = 0
    private var standardC = 0
    private var standardD = 0
    private var standardE = 0
    private var standardF = 0
    private var standardG = 0
    private var standardH = 0
    private var standardI = 0
    private var standardJ = 0
    private var standardK = 0
    private var standardL = 0
    private var standardM = 0
    private var standardN = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        studentViewModel = ViewModelProvider(this)[StudentViewModel::class.java]

        binding = FragmentConnersResultBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this){
            findNavController().navigate(R.id.action_connersResultFragment_to_adhdTestsFragment)
        }
        callback.isEnabled = true

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        getStandardDegree()


        binding.connersResultText1.text = "الدرجة الكلية : $totalPoints"
        binding.connersResultText2.text =   "بند المعارضة -> \n" +
                "الدرجة الخام للبند : $testA\n" +
                "الدرجة المعيارية للبند : $standardA\n" +
                "تصنيف البند : ${setResult(standardA)}"
        binding.connersResultText3.text =   "بند مشاكل معرفية -> \n" +
                "الدرجة الخام للبند : $testB\n" +
                "الدرجة المعيارية للبند : $standardB\n" +
                "تصنيف البند : ${setResult(standardB)}"
        binding.connersResultText4.text =  "بند الحركة الزائدة أو فرط الحركة -> \n" +
                "الدرجة الخام للبند : $testC\n" +
                "الدرجة المعيارية للبند : $standardC\n" +
                "تصنيف البند : ${setResult(standardC)}"

        binding.connersResultText5.text =   "بند القلق والخجل -> \n" +
                "الدرجة الخام للبند : $testD\n" +
                "الدرجة المعيارية للبند : $standardD\n" +
                "تصنيف البند : ${setResult(standardD)}"



        binding.connersResultText6.text =  "بند الكمالية -> \n" +
                "الدرجة الخام للبند : $testE\n" +
                "الدرجة المعيارية للبند : $standardE\n" +
                "تصنيف البند : ${setResult(standardE)}"


        binding.connersResultText7.text =  "بند المشكلات الاجتماعية -> \n" +
                "الدرجة الخام للبند : $testF\n" +
                "الدرجة المعيارية للبند : $standardF\n" +
                "تصنيف البند : ${setResult(standardF)}"



        binding.connersResultText8.text =    "بند امراض نفسية،جسمية -> \n" +
                "الدرجة الخام للبند : $testG\n" +
                "الدرجة المعيارية للبند : $standardG\n" +
                "تصنيف البند : ${setResult(standardG)}"




        binding.connersResultText9.text =     "بند التعرف علي الاشخاص المصابين ب ADHD -> \n" +
                "الدرجة الخام للبند : $testH\n" +
                "الدرجة المعيارية للبند : $standardH\n" +
                "تصنيف البند : ${setResult(standardH)}"



        binding.connersResultText10.text =   "بند عدم الراحة وفرط الحركة -> \n" +
                "الدرجة الخام للبند : $testI\n" +
                "الدرجة المعيارية للبند : $standardI\n" +
                "تصنيف البند : ${setResult(standardI)}"


        binding.connersResultText11.text =  "بند الاستجابات الانفعالية -> \n" +
                "الدرجة الخام للبند : $testJ\n" +
                "الدرجة المعيارية للبند : $standardJ\n" +
                "تصنيف البند : ${setResult(standardJ)}"


        binding.connersResultText12.text =   "بند معايير كونرز العالمية الكلية -> \n" +
                "الدرجة الخام للبند : $testK\n" +
                "الدرجة المعيارية للبند : $standardK\n" +
                "تصنيف البند : ${setResult(standardK)}"




        binding.connersResultText13.text =   "بند التشخيص الاحصائي لضعف الانتباه  -> \n" +
                "الدرجة الخام للبند : $testL\n" +
                "الدرجة المعيارية للبند : $standardL\n" +
                "تصنيف البند : ${setResult(standardL)}"



        binding.connersResultText14.text =  "بند التشخيص الاحصائي للنشاط الزائد والاندفاعية -> \n" +
                "الدرجة الخام للبند : $testM\n" +
                "الدرجة المعيارية للبند : $standardM\n" +
                "تصنيف البند : ${setResult(standardM)}"


        binding.connersResultText15.text =  "بند معايير التشخيص الكلية ل ADHD  -> \n" +
                "الدرجة الخام للبند : $testN\n" +
                "الدرجة المعيارية للبند : $standardN\n" +
                "تصنيف البند : ${setResult(standardN)}"


        binding.goHomeButton.setOnClickListener {
            findNavController().navigate(R.id.action_connersResultFragment_to_adhdTestsFragment)
        }



        binding.addTestResult.setOnClickListener {
            addValueToStudent("بند المعارضة",  standardA.toString())
            addValueToStudent("بند مشاكل معرفية",  standardB.toString())
            addValueToStudent("بند الحركة الزائدة أو فرط الحركة",  standardC.toString())
            addValueToStudent("بند القلق والخجل",  standardD.toString())
            addValueToStudent("بند الكمالية",  standardE.toString())
            addValueToStudent("بند المشكلات الاجتماعية",  standardF.toString())
            addValueToStudent("بند امراض نفسية،جسمية",  standardG.toString())
            addValueToStudent("بند التعرف علي الاشخاص المصابين ب ADHD",  standardH.toString())
            addValueToStudent("بند عدم الراحة وفرط الحركة",  standardI.toString())
            addValueToStudent("بند الاستجابات الانفعالية",  standardJ.toString())
            addValueToStudent("بند معايير كونرز العالمية الكلية",  standardK.toString())
            addValueToStudent("بند التشخيص الاحصائي لضعف الانتباه",  standardL.toString())
            addValueToStudent("بند التشخيص الاحصائي للنشاط الزائد والاندفاعية",  standardM.toString())
            addValueToStudent("بند معايير التشخيص الكلية ل ADHD",  standardN.toString())



        }
    }



    private fun addValueToStudent(testName:String, valueOfQuiz: String) {

        var quiz = Quiz(mainTest = constant.quizTypeAdhd,testName, constant.quizTypeconares,
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



    private fun getStandardDegree(){

        if (sex == 1){

            when(age){
                in 3..5 -> {
                    standardA = ConnersGetStandardDegree_3_5Female.PartA3_5Female[testA]!!
                    standardB = ConnersGetStandardDegree_3_5Female.PartB3_5Female[testB]!!
                    standardC = ConnersGetStandardDegree_3_5Female.PartC3_5Female[testC]!!
                    standardD = ConnersGetStandardDegree_3_5Female.PartD3_5Female[testD]!!
                    standardE = ConnersGetStandardDegree_3_5Female.PartE3_5Female[testE]!!
                    standardF = ConnersGetStandardDegree_3_5Female.PartF3_5Female[testF]!!
                    standardG = ConnersGetStandardDegree_3_5Female.PartG3_5Female[testG]!!
                    standardH = ConnersGetStandardDegree_3_5Female.PartH3_5Female[testH]!!
                    standardI = ConnersGetStandardDegree_3_5Female.PartI3_5Female[testI]!!
                    standardJ = ConnersGetStandardDegree_3_5Female.PartJ3_5Female[testJ]!!
                    standardK = ConnersGetStandardDegree_3_5Female.PartK3_5Female[testK]!!
                    standardL = ConnersGetStandardDegree_3_5Female.PartL3_5Female[testL]!!
                    standardM = ConnersGetStandardDegree_3_5Female.PartM3_5Female[testM]!!
                    standardN = ConnersGetStandardDegree_3_5Female.PartN3_5Female[testN]!!
                }

                in 6..8 ->{
                    standardA = ConnersGetStandardDegree_6_8Female.PartA6_8Female[testA]!!
                    standardB = ConnersGetStandardDegree_6_8Female.PartB6_8Female[testB]!!
                    standardC = ConnersGetStandardDegree_6_8Female.PartC6_8Female[testC]!!
                    standardD = ConnersGetStandardDegree_6_8Female.PartD6_8Female[testD]!!
                    standardE = ConnersGetStandardDegree_6_8Female.PartE6_8Female[testE]!!
                    standardF = ConnersGetStandardDegree_6_8Female.PartF6_8Female[testF]!!
                    standardG = ConnersGetStandardDegree_6_8Female.PartG6_8Female[testG]!!
                    standardH = ConnersGetStandardDegree_6_8Female.PartH6_8Female[testH]!!
                    standardI = ConnersGetStandardDegree_6_8Female.PartI6_8Female[testI]!!
                    standardJ = ConnersGetStandardDegree_6_8Female.PartJ6_8Female[testJ]!!
                    standardK = ConnersGetStandardDegree_6_8Female.PartK6_8Female[testK]!!
                    standardL = ConnersGetStandardDegree_6_8Female.PartL6_8Female[testL]!!
                    standardM = ConnersGetStandardDegree_6_8Female.PartM6_8Female[testM]!!
                    standardN = ConnersGetStandardDegree_6_8Female.PartN6_8Female[testN]!!
                }

                in 9..11 ->{
                    standardA = ConnersGetStandardDegree_9_11Female.PartA9_11Female[testA]!!
                    standardB = ConnersGetStandardDegree_9_11Female.PartB9_11Female[testB]!!
                    standardC = ConnersGetStandardDegree_9_11Female.PartC9_11Female[testC]!!
                    standardD = ConnersGetStandardDegree_9_11Female.PartD9_11Female[testD]!!
                    standardE = ConnersGetStandardDegree_9_11Female.PartE9_11Female[testE]!!
                    standardF = ConnersGetStandardDegree_9_11Female.PartF9_11Female[testF]!!
                    standardG = ConnersGetStandardDegree_9_11Female.PartG9_11Female[testG]!!
                    standardH = ConnersGetStandardDegree_9_11Female.PartH9_11Female[testH]!!
                    standardI = ConnersGetStandardDegree_9_11Female.PartI9_11Female[testI]!!
                    standardJ = ConnersGetStandardDegree_9_11Female.PartJ9_11Female[testJ]!!
                    standardK = ConnersGetStandardDegree_9_11Female.PartK9_11Female[testK]!!
                    standardL = ConnersGetStandardDegree_9_11Female.PartL9_11Female[testL]!!
                    standardM = ConnersGetStandardDegree_9_11Female.PartM9_11Female[testM]!!
                    standardN = ConnersGetStandardDegree_9_11Female.PartN9_11Female[testN]!!
                }

                in 12..14 ->{
                    standardB = ConnersGetStandardDegree_12_14Female.PartB12_14Female[testB]!!
                    standardA = ConnersGetStandardDegree_12_14Female.PartA12_14Female[testA]!!
                    standardC = ConnersGetStandardDegree_12_14Female.PartC12_14Female[testC]!!
                    standardD = ConnersGetStandardDegree_12_14Female.PartD12_14Female[testD]!!
                    standardE = ConnersGetStandardDegree_12_14Female.PartE12_14Female[testE]!!
                    standardF = ConnersGetStandardDegree_12_14Female.PartF12_14Female[testF]!!
                    standardH = ConnersGetStandardDegree_12_14Female.PartH12_14Female[testH]!!
                    standardG = ConnersGetStandardDegree_12_14Female.PartG12_14Female[testG]!!
                    standardI = ConnersGetStandardDegree_12_14Female.PartI12_14Female[testI]!!
                    standardJ = ConnersGetStandardDegree_12_14Female.PartJ12_14Female[testJ]!!
                    standardK = ConnersGetStandardDegree_12_14Female.PartK12_14Female[testK]!!
                    standardL = ConnersGetStandardDegree_12_14Female.PartL12_14Female[testL]!!
                    standardM = ConnersGetStandardDegree_12_14Female.PartM12_14Female[testM]!!
                    standardN = ConnersGetStandardDegree_12_14Female.PartN12_14Female[testN]!!
                }

                in 15..17 ->{
                    standardB = ConnersGetStandardDegree_15_17Female.PartB15_17Female[testB]!!
                    standardA = ConnersGetStandardDegree_15_17Female.PartA15_17Female[testA]!!
                    standardC = ConnersGetStandardDegree_15_17Female.PartC15_17Female[testC]!!
                    standardD = ConnersGetStandardDegree_15_17Female.PartD15_17Female[testD]!!
                    standardE = ConnersGetStandardDegree_15_17Female.PartE15_17Female[testE]!!
                    standardF = ConnersGetStandardDegree_15_17Female.PartF15_17Female[testF]!!
                    standardH = ConnersGetStandardDegree_15_17Female.PartH15_17Female[testH]!!
                    standardG = ConnersGetStandardDegree_15_17Female.PartG15_17Female[testG]!!
                    standardI = ConnersGetStandardDegree_15_17Female.PartI15_17Female[testI]!!
                    standardJ = ConnersGetStandardDegree_15_17Female.PartJ15_17Female[testJ]!!
                    standardK = ConnersGetStandardDegree_15_17Female.PartK15_17Female[testK]!!
                    standardL = ConnersGetStandardDegree_15_17Female.PartL15_17Female[testL]!!
                    standardM = ConnersGetStandardDegree_15_17Female.PartM15_17Female[testM]!!
                    standardN = ConnersGetStandardDegree_15_17Female.PartN15_17Female[testN]!!
                }
            }

        }else {

            when (age) {
                in 3..5 -> {
                    standardA = ConnersGetStandardDegree_3_5Male.PartA3_5Male[testA]!!
                    standardB = ConnersGetStandardDegree_3_5Male.PartB3_5Male[testB]!!
                    standardC = ConnersGetStandardDegree_3_5Male.PartC3_5Male[testC]!!
                    standardD = ConnersGetStandardDegree_3_5Male.PartD3_5Male[testD]!!
                    standardE = ConnersGetStandardDegree_3_5Male.PartE3_5Male[testE]!!
                    standardF = ConnersGetStandardDegree_3_5Male.PartF3_5Male[testF]!!
                    standardG = ConnersGetStandardDegree_3_5Male.PartG3_5Male[testG]!!
                    standardH = ConnersGetStandardDegree_3_5Male.PartH3_5Male[testH]!!
                    standardI = ConnersGetStandardDegree_3_5Male.PartI3_5Male[testI]!!
                    standardJ = ConnersGetStandardDegree_3_5Male.PartJ3_5Male[testJ]!!
                    standardK = ConnersGetStandardDegree_3_5Male.PartK3_5Male[testK]!!
                    standardL = ConnersGetStandardDegree_3_5Male.PartL3_5Male[testL]!!
                    standardM = ConnersGetStandardDegree_3_5Male.PartM3_5Male[testM]!!
                    standardN = ConnersGetStandardDegree_3_5Male.PartN3_5Male[testN]!!
                }

                in 6..8 -> {
                    standardA = ConnersGetStandardDegree_6_8Male.PartA6_8Male[testA]!!
                    standardB = ConnersGetStandardDegree_6_8Male.PartB6_8Male[testB]!!
                    standardC = ConnersGetStandardDegree_6_8Male.PartC6_8Male[testC]!!
                    standardD = ConnersGetStandardDegree_6_8Male.PartD6_8Male[testD]!!
                    standardE = ConnersGetStandardDegree_6_8Male.PartE6_8Male[testE]!!
                    standardF = ConnersGetStandardDegree_6_8Male.PartF6_8Male[testF]!!
                    standardG = ConnersGetStandardDegree_6_8Male.PartG6_8Male[testG]!!
                    standardH = ConnersGetStandardDegree_6_8Male.PartH6_8Male[testH]!!
                    standardI = ConnersGetStandardDegree_6_8Male.PartI6_8Male[testI]!!
                    standardJ = ConnersGetStandardDegree_6_8Male.PartJ6_8Male[testJ]!!
                    standardK = ConnersGetStandardDegree_6_8Male.PartK6_8Male[testK]!!
                    standardL = ConnersGetStandardDegree_6_8Male.PartL6_8Male[testL]!!
                    standardM = ConnersGetStandardDegree_6_8Male.PartM6_8Male[testM]!!
                    standardN = ConnersGetStandardDegree_6_8Male.PartN6_8Male[testN]!!
                }

                in 9..11 -> {
                    standardA = ConnersGetStandardDegree_9_11Male.PartA9_11Male[testA]!!
                    standardB = ConnersGetStandardDegree_9_11Male.PartB9_11Male[testB]!!
                    standardC = ConnersGetStandardDegree_9_11Male.PartC9_11Male[testC]!!
                    standardD = ConnersGetStandardDegree_9_11Male.PartD9_11Male[testD]!!
                    standardE = ConnersGetStandardDegree_9_11Male.PartE9_11Male[testE]!!
                    standardF = ConnersGetStandardDegree_9_11Male.PartF9_11Male[testF]!!
                    standardG = ConnersGetStandardDegree_9_11Male.PartG9_11Male[testG]!!
                    standardH = ConnersGetStandardDegree_9_11Male.PartH9_11Male[testH]!!
                    standardI = ConnersGetStandardDegree_9_11Male.PartI9_11Male[testI]!!
                    standardJ = ConnersGetStandardDegree_9_11Male.PartJ9_11Male[testJ]!!
                    standardK = ConnersGetStandardDegree_9_11Male.PartK9_11Male[testK]!!
                    standardL = ConnersGetStandardDegree_9_11Male.PartL9_11Male[testL]!!
                    standardM = ConnersGetStandardDegree_9_11Male.PartM9_11Male[testM]!!
                    standardN = ConnersGetStandardDegree_9_11Male.PartN9_11Male[testN]!!
                }

                in 12..14 -> {
                    standardB = ConnersGetStandardDegree_12_14Male.PartB12_14Male[testB]!!
                    standardA = ConnersGetStandardDegree_12_14Male.PartA12_14Male[testA]!!
                    standardC = ConnersGetStandardDegree_12_14Male.PartC12_14Male[testC]!!
                    standardD = ConnersGetStandardDegree_12_14Male.PartD12_14Male[testD]!!
                    standardE = ConnersGetStandardDegree_12_14Male.PartE12_14Male[testE]!!
                    standardF = ConnersGetStandardDegree_12_14Male.PartF12_14Male[testF]!!
                    standardH = ConnersGetStandardDegree_12_14Male.PartH12_14Male[testH]!!
                    standardG = ConnersGetStandardDegree_12_14Male.PartG12_14Male[testG]!!
                    standardI = ConnersGetStandardDegree_12_14Male.PartI12_14Male[testI]!!
                    standardJ = ConnersGetStandardDegree_12_14Male.PartJ12_14Male[testJ]!!
                    standardK = ConnersGetStandardDegree_12_14Male.PartK12_14Male[testK]!!
                    standardL = ConnersGetStandardDegree_12_14Male.PartL12_14Male[testL]!!
                    standardM = ConnersGetStandardDegree_12_14Male.PartM12_14Male[testM]!!
                    standardN = ConnersGetStandardDegree_12_14Male.PartN12_14Male[testN]!!
                }

                in 15..17 -> {
                    standardB = ConnersGetStandardDegree_15_17Male.PartB15_17Male[testB]!!
                    standardA = ConnersGetStandardDegree_15_17Male.PartA15_17Male[testA]!!
                    standardC = ConnersGetStandardDegree_15_17Male.PartC15_17Male[testC]!!
                    standardD = ConnersGetStandardDegree_15_17Male.PartD15_17Male[testD]!!
                    standardE = ConnersGetStandardDegree_15_17Male.PartE15_17Male[testE]!!
                    standardF = ConnersGetStandardDegree_15_17Male.PartF15_17Male[testF]!!
                    standardH = ConnersGetStandardDegree_15_17Male.PartH15_17Male[testH]!!
                    standardG = ConnersGetStandardDegree_15_17Male.PartG15_17Male[testG]!!
                    standardI = ConnersGetStandardDegree_15_17Male.PartI15_17Male[testI]!!
                    standardJ = ConnersGetStandardDegree_15_17Male.PartJ15_17Male[testJ]!!
                    standardK = ConnersGetStandardDegree_15_17Male.PartK15_17Male[testK]!!
                    standardL = ConnersGetStandardDegree_15_17Male.PartL15_17Male[testL]!!
                    standardM = ConnersGetStandardDegree_15_17Male.PartM15_17Male[testM]!!
                    standardN = ConnersGetStandardDegree_15_17Male.PartN15_17Male[testN]!!
                }
            }
        }
    }

    private fun setResult(standard: Int) :String{

        var result = ""
        result =  when(standard){
            in 0..29 -> "أقل من المتوسط بدرجة كبيرة جدا"
            in 30..34 -> "أقل من المتوسط بدرجة كبيرة "
            in 35..39 -> "أقل من المتوسط"
            in 40..44 -> "أقل من المتوسط بدرجة طفيفة"
            in 45..55 -> "متوسط"
            in 56..60 -> "فوق المتوسط بدرجة طفيفة"
            in 61..65 -> "فوق المتوسط"
            in 66..70 -> "فوق المتوسط بدرجة كبيرة "
            else -> "فوق المتوسط بدرجة كبيرة جدا "
        }

        return result
    }

    companion object {
       var totalPoints = 0
         var testA =0
         var testB =0
         var testC =0
         var testD =0
         var testE = 0
         var testF = 0
         var testG = 0
         var testH = 0
         var testI = 0
         var testJ = 0
         var testK = 0
         var testL = 0
         var testM = 0
         var testN = 0

        var age =0
        var sex = 0


        lateinit var currentStudent: Student
    }
}

//        binding.connersResultText.text = "الدرجة الكلية : $totalPoints\n" +
//                "بند المعارضة -> \n" +
//                "الدرجة الخام للبند : $testA\n" +
//                "الدرجة المعيارية للبند : $standardA\n" +
//                "تصنيف البند : ${setResult(standardA)}\n\n" +
//                "بند مشاكل معرفية -> \n" +
//                "الدرجة الخام للبند : $testB\n" +
//                "الدرجة المعيارية للبند : $standardB\n" +
//                "تصنيف البند : ${setResult(standardB)}\n\n" +
//                "بند الحركة الزائدة أو فرط الحركة -> \n" +
//                "الدرجة الخام للبند : $testC\n" +
//                "الدرجة المعيارية للبند : $standardC\n" +
//                "تصنيف البند : ${setResult(standardC)}\n\n" +
//                "بند القلق والخجل -> \n" +
//                "الدرجة الخام للبند : $testD\n" +
//                "الدرجة المعيارية للبند : $standardD\n" +
//                "تصنيف البند : ${setResult(standardD)}\n\n" +
//                "بند الكمالية -> \n" +
//                "الدرجة الخام للبند : $testE\n" +
//                "الدرجة المعيارية للبند : $standardE\n" +
//                "تصنيف البند : ${setResult(standardE)}\n\n" +
//                "بند المشكلات الاجتماعية -> \n" +
//                "الدرجة الخام للبند : $testF\n" +
//                "الدرجة المعيارية للبند : $standardF\n" +
//                "تصنيف البند : ${setResult(standardF)}\n\n" +
//                "بند امراض نفسية،جسمية -> \n" +
//                "الدرجة الخام للبند : $testG\n" +
//                "الدرجة المعيارية للبند : $standardG\n" +
//                "تصنيف البند : ${setResult(standardG)}\n\n" +
//                "بند التعرف علي الاشخاص المصابين ب ADHD -> \n" +
//                "الدرجة الخام للبند : $testH\n" +
//                "الدرجة المعيارية للبند : $standardH\n" +
//                "تصنيف البند : ${setResult(standardH)}\n\n" +
//                "بند عدم الراحة وفرط الحركة -> \n" +
//                "الدرجة الخام للبند : $testI\n" +
//                "الدرجة المعيارية للبند : $standardI\n" +
//                "تصنيف البند : ${setResult(standardI)}\n\n" +
//                "بند الاستجابات الانفعالية -> \n" +
//                "الدرجة الخام للبند : $testJ\n" +
//                "الدرجة المعيارية للبند : $standardJ\n" +
//                "تصنيف البند : ${setResult(standardJ)}\n\n" +
//                "بند معايير كونرز العالمية الكلية -> \n" +
//                "الدرجة الخام للبند : $testK\n" +
//                "الدرجة المعيارية للبند : $standardK\n" +
//                "تصنيف البند : ${setResult(standardK)}\n\n" +
//                "بند التشخيص الاحصائي لضعف الانتباه  -> \n" +
//                "الدرجة الخام للبند : $testL\n" +
//                "الدرجة المعيارية للبند : $standardL\n" +
//                "تصنيف البند : ${setResult(standardL)}\n\n" +
//                "بند التشخيص الاحصائي للنشاط الزائد والاندفاعية -> \n" +
//                "الدرجة الخام للبند : $testM\n" +
//                "الدرجة المعيارية للبند : $standardM\n" +
//                "تصنيف البند : ${setResult(standardM)}\n\n" +
//                "بند معايير التشخيص الكلية ل ADHD  -> \n" +
//                "الدرجة الخام للبند : $testN\n" +
//                "الدرجة المعيارية للبند : $standardN\n" +
//                "تصنيف البند : ${setResult(standardN)}\n\n"
//                " الدرجة الخام للبند A :$testA\n" +
//                "الدرجة الخام للبند B :$testB\n" +
//                "الدرجة الخام للبند C :$testC\n" +
//                "الدرجة الخام للبند D :$testD\n" +
//                "الدرجة الخام للبند E :$testE\n" +
//                "الدرجة الخام للبند F :$testF\n" +
//                "الدرجة الخام للبند G :$testG\n" +
//                "الدرجة الخام للبند H :$testH\n" +
//                "الدرجة الخام للبند I :$testI\n" +
//                "الدرجة الخام للبند J :$testJ\n" +
//                "الدرجة الخام للبند K :$testK\n" +
//                "الدرجة الخام للبند L :$testL\n" +
//                "الدرجة الخام للبند M :$testM\n" +
//                "الدرجة الخام للبند N :$testN\n" +
//                "الدرجة المعيارية للبند A : $standardA\n" +
//                "الدرجة المعيارية للبند B : $standardB \n"+
//                "الدرجة المعيارية للبند C : $standardC \n"+
//                "الدرجة المعيارية للبند D :$standardD \n"+
//                "الدرجة المعيارية للبند E :$standardE \n"+
//                "الدرجة المعيارية للبند F :$standardF \n"+
//                "الدرجة المعيارية للبند G : $standardG \n"+
//                "الدرجة المعيارية للبند H :$standardH \n"+
//                "الدرجة المعيارية للبند I :$standardI \n"+
//                "الدرجة المعيارية للبند J :$standardJ \n"+
//                "الدرجة المعيارية للبند K :$standardK \n"+
//                "الدرجة المعيارية للبند L :$standardL \n"+
//                "الدرجة المعيارية للبند M :$standardM \n"+
//                "الدرجة المعيارية للبند N :$standardN \n" +
//                "تصنيف البند A :${setResult(standardA)}\n"+
//                "تصنيف البند B :${setResult(standardB)}\n"+
//                "تصنيف البند C :${setResult(standardC)}\n"+
//                "تصنيف البند D :${setResult(standardD)}\n"+
//                "تصنيف البند E :${setResult(standardE)}\n"+
//                "تصنيف البند F :${setResult(standardF)}\n"+
//                "تصنيف البند G :${setResult(standardG)}\n"+
//                "تصنيف البند H :${setResult(standardH)}\n"+
//                "تصنيف البند I :${setResult(standardI)}\n"+
//                "تصنيف البند J :${setResult(standardJ)}\n"+
//                "تصنيف البند K :${setResult(standardK)}\n"+
//                "تصنيف البند L :${setResult(standardL)}\n"+
//                "تصنيف البند M :${setResult(standardM)}\n"+
//                "تصنيف البند N :${setResult(standardN)}\n"
