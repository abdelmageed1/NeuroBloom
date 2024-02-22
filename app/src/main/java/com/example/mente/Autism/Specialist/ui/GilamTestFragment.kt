package com.example.mente.Autism.Specialist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mente.Autism.Data.QuestionsSpecialist.GilamData
import com.example.mente.R
import com.example.mente.Student.Model.Student
import com.example.mente.databinding.FragmentGilamTestBinding


class GilamTestFragment : Fragment() {

    lateinit var binding: FragmentGilamTestBinding
    lateinit var arrQuestion: MutableList<String>
    private var indexCurrentQuestion = 0
    private var totalPoints = 0
    private var test1 =0
    private var test2 =0
    private var test3 =0
    private var test4 =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arrQuestion = GilamData.GilamData
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subTestTitle()
        setBtnNext()
        setQuestionInView()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGilamTestBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private fun subTestTitle(){

        binding.gilamSubTestName.text = when(indexCurrentQuestion){
            in 0..13 -> "السلوكيات النمطية"
            in 14..27 -> "التواصل"
            in 28..41 -> "التفاعل الاجتماعي"
            else -> "اضطرابات النمو"
        }

    }

    private fun setBtnNext(){
        binding.radioGroupGilam.setOnCheckedChangeListener { radioGroup, radioId ->

            var ans = 0
            var isChecked = true

            when(radioId){
                R.id.rbGilamSelect1 -> ans = 0
                R.id.rbGilamSelect2 -> ans = 1
                R.id.rbGilamSelect3 -> ans = 2
                R.id.rbGilamSelect4 -> ans = 3

                else -> isChecked = false
            }

            if (isChecked){
                totalPoints += ans
                setDegree(ans)
                indexCurrentQuestion++

                if (indexCurrentQuestion < arrQuestion.size) {

                    setQuestionInView()
                }else{
                    findNavController().navigate(R.id.action_gilamTestFragment_to_gilamResultFragment)
                    GilamResultFragment.totalPoints = totalPoints
                    GilamResultFragment.test1 = test1
                    GilamResultFragment.test2 = test2
                    GilamResultFragment.test3 = test3
                    GilamResultFragment.test4 = test4

                }

            }

            subTestTitle()
        }
    }

    private fun setQuestionInView() {
        updateProgressBar()
        if (indexCurrentQuestion < arrQuestion.size){
            binding.tvQTitleGilam.text =  arrQuestion[indexCurrentQuestion]
            binding.radioGroupGilam.clearCheck()
            if (indexCurrentQuestion in 42..55){
                binding.rbGilamSelect1.text = "لا"
                binding.rbGilamSelect2.text = "نعم"
                binding.rbGilamSelect3.visibility = View.GONE
                binding.rbGilamSelect4.visibility = View.GONE

            }
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

    private fun setDegree(ans: Int) {

        when(indexCurrentQuestion){
            in 0..13 -> test1 += ans
            in 14..27 -> test2 += ans
            in 28..41 -> test3 += ans
            in 42..55 -> test4 += ans
        }
    }

    companion object {
        lateinit var categoryQuestion: String
        lateinit var student: Student

    }

}