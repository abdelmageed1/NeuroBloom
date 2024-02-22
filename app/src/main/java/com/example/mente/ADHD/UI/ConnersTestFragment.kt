package com.example.mente.ADHD.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mente.ADHD.Data.ConnersData
import com.example.mente.R
import com.example.mente.Student.Model.Student
import com.example.mente.databinding.FragmentConnersTestBinding


class ConnersTestFragment : Fragment() {

    lateinit var binding: FragmentConnersTestBinding
    lateinit var arrQuestion: MutableList<String>
    private var indexCurrentQuestion = 0
    private var totalPoints = 0
    private var testA =0
    private var testB =0
    private var testC =0
    private var testD =0
    private var testE = 0
    private var testF = 0
    private var testG = 0
    private var testH = 0
    private var testI = 0
    private var testJ = 0
    private var testK = 0
    private var testL = 0
    private var testM = 0
    private var testN = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arrQuestion = ConnersData.ConnersData


        val callback = requireActivity().onBackPressedDispatcher.addCallback(this){
            findNavController().navigate(R.id.action_connersTestFragment_to_adhdTestsFragment)
        }
        callback.isEnabled = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentConnersTestBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBtnNext()
        setQuestionInView()
    }

    private fun setQuestionInView() {
        updateProgressBar()
        if (indexCurrentQuestion < arrQuestion.size){
            binding.tvQTitleConners.text =  arrQuestion[indexCurrentQuestion]
            binding.radioGroupConners.clearCheck()
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
        binding.radioGroupConners.setOnCheckedChangeListener { radioGroup, radioId ->

            var ans = 0
            var isChecked = true

            when(radioId){
                R.id.rbConnersSelect1 -> ans = 0
                R.id.rbConnersSelect2 -> ans = 1
                R.id.rbConnersSelect3 -> ans = 2
                R.id.rbConnersSelect4 -> ans = 3

                else -> isChecked = false
            }

            if (isChecked){
                totalPoints += ans
                setDegree(ans)
                indexCurrentQuestion++

                if (indexCurrentQuestion < arrQuestion.size) {

                    setQuestionInView()
                }else{
                    findNavController().navigate(R.id.action_connersTestFragment_to_connersResultFragment)
                    ConnersResultFragment.totalPoints = totalPoints
                    ConnersResultFragment.testA = testA
                    ConnersResultFragment.testB = testB
                    ConnersResultFragment.testC = testC
                    ConnersResultFragment.testD = testD
                    ConnersResultFragment.testE = testE
                    ConnersResultFragment.testF = testF
                    ConnersResultFragment.testG = testG
                    ConnersResultFragment.testH = testH
                    ConnersResultFragment.testI = testI
                    ConnersResultFragment.testJ = testJ
                    ConnersResultFragment.testK = testK
                    ConnersResultFragment.testL = testL
                    ConnersResultFragment.testM = testM
                    ConnersResultFragment.testN = testN

                }

            }

        }
    }







    private fun setDegree(ans: Int) {

        when(indexCurrentQuestion){
            in arrayOf(46,74,76) -> { testJ +=ans}
        }

        when(indexCurrentQuestion){
            in arrayOf(5,15,25,71,34) -> { testF +=ans}
        }


        when(indexCurrentQuestion){
            in arrayOf(45,6,16,26,72,35) -> { testG +=ans}
        }

        when(indexCurrentQuestion){
            in arrayOf(43,4,53,14,63,24,33) -> { testE +=ans}
        }

        when(indexCurrentQuestion){
            in arrayOf(37,17,61,65,67,27,36) -> { testI +=ans}
        }

        when(indexCurrentQuestion){
            in arrayOf(42,3,52,13,59,64,23,32) -> { testD +=ans}
        }

        when(indexCurrentQuestion){
            in arrayOf(40,49,8,9,19,70,28,29,78) -> { testL +=ans}
        }

        when(indexCurrentQuestion){
            in arrayOf(41,2,51,12,58,22,27,31,79) -> { testC +=ans}
        }

        when(indexCurrentQuestion){
            in arrayOf(38,41,2,48,54,58,22,75,79) -> { testM +=ans}
        }

        when(indexCurrentQuestion){
            in arrayOf(39,0,7,10,56,60,20,66,69,30) -> { testA +=ans }
        }

        when(indexCurrentQuestion){
            in arrayOf(37,46,17,61,65,67,27,74,76,36) -> { testK +=ans}
        }

        when(indexCurrentQuestion){
            in arrayOf(40,1,49,50,8,11,57,18,21,70,28,73) -> { testB +=ans}
        }

        when(indexCurrentQuestion){
            in arrayOf(37,44,47,8,54,55,18,62,68,28,75,77) -> { testH +=ans}
        }

        when(indexCurrentQuestion){
            in arrayOf(38,40,41,2,48,49,51,52,54,58,19,22,70,28,29,75,78,79) -> { testN +=ans}
        }



//        when (indexCurrentQuestion) {
//
//            in arrayOf(46,74,76) -> { testJ +=ans}
//            in arrayOf(5,15,25,71,34) -> { testF +=ans}
//            in arrayOf(45,6,16,26,72,35) -> { testG +=ans}
//            in arrayOf(43,4,53,14,63,24,33) -> { testE +=ans}
//            in arrayOf(37,17,61,65,67,27,36) -> { testI +=ans}
//            in arrayOf(42,3,52,13,59,64,23,32) -> { testD +=ans}
//            in arrayOf(40,49,8,9,19,70,28,29,78) -> { testL +=ans}
//            in arrayOf(41,2,51,12,58,22,27,31,79) -> { testC +=ans}
//            in arrayOf(38,41,2,48,54,58,22,75,79) -> { testM +=ans}
//            in arrayOf(39,0,7,10,56,60,20,66,69,30) -> { testA +=ans }
//            in arrayOf(37,46,17,61,65,67,27,74,76,36) -> { testK +=ans}
//            in arrayOf(40,1,49,50,8,11,57,18,21,70,28,73) -> { testB +=ans}
//            in arrayOf(37,44,47,8,54,55,18,62,68,28,75,77) -> { testH +=ans}
//            in arrayOf(38,40,41,2,48,49,51,52,54,58,19,22,70,28,29,75,78,79) -> { testN +=ans}
//
//
//        }

    }

    companion object {
        lateinit var categoryQuestion: String
        lateinit var student: Student


    }
}