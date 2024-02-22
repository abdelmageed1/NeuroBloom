package com.example.mente.Autism.Specialist.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mente.Autism.Specialist.ui.Qchat10Fragment.Companion.questionsListAns
import com.example.mente.R
import com.example.mente.databinding.FragmentEvaluationAutismBinding


class EvaluationAutismFragment : Fragment() {

    lateinit var binding: FragmentEvaluationAutismBinding
    private var ageMons = 0
    private var sexF = 0
    private var sexM = 0
    private var jaundiceNo = 0
    private var jaundiceYes = 0
    private var familyMemWithASDNo = 0
    private var familyMemWithASDYes = 0
    private var ageText: Int? = 0
    private var allSelected = false
    private var validationError = ""
    private var childInfoList = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEvaluationAutismBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAnswers()
        binding.goToTestButton.setOnClickListener { inputValidation() }

//        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }



    private fun getAnswers() {

        ageText = binding.ageMons.text.toString().toIntOrNull()

        binding.radioGroupGender.setOnCheckedChangeListener { _, selected ->
            sexF = when (selected) {
                R.id.femaleRadio -> 1
                else -> 0
            }
            sexM = when (selected) {
                R.id.maleRadio -> 1
                else -> 0
            }
        }

        binding.radioGroupJaundice.setOnCheckedChangeListener { _, selected ->
            jaundiceYes = when (selected) {
                R.id.yesJaundiceRadio -> 1
                else -> 0
            }
            jaundiceNo = when (selected) {
                R.id.noJaundiceRadio -> 1
                else -> 0
            }
        }

        binding.radioGroupFamilyMember.setOnCheckedChangeListener { _, selected ->
            familyMemWithASDYes = when (selected) {
                R.id.yesFamilyMemberRadio -> 1
                else -> 0
            }
            familyMemWithASDNo = when (selected) {
                R.id.noFamilyMemberRadio -> 1
                else -> 0
            }
        }

    }



    private fun inputValidation(){

        getAnswers()

        allSelected =
            binding.radioGroupGender.checkedRadioButtonId != -1 &&
                    binding.radioGroupJaundice.checkedRadioButtonId != -1 &&
                    binding.radioGroupFamilyMember.checkedRadioButtonId != -1

        validationError = when {
            !allSelected -> "اكمل البيانات !"
            ageText == null -> "ادخل أشهر العمر !"
            else -> " العمر يجب أن يكون بين 18 إلي 30 شهر !"
        }

        if ((ageText != null) && (ageText in (18..30)) && allSelected) {
            ageMons = ageText as Int
            childInfoList.addAll(
                listOf(
                    ageMons,
                    sexF,
                    sexM,
                    jaundiceNo,
                    jaundiceYes,
                    familyMemWithASDNo,
                    familyMemWithASDYes
                )
            )
            questionsListAns = childInfoList
            findNavController().navigate(R.id.action_evaluationAutismFragment_to_qchat10Fragment)
        } else {
            Toast.makeText(context, validationError, Toast.LENGTH_SHORT).show()
        }
    }
}


