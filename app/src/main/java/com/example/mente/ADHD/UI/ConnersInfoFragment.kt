package com.example.mente.ADHD.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mente.R
import com.example.mente.databinding.FragmentConnersInfoBinding


class ConnersInfoFragment : Fragment() {

    lateinit var binding: FragmentConnersInfoBinding
    private var ageText: Int? = 0
    private var allSelected = false
    private var validationError = ""
    private var sex = 0
    private var age = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentConnersInfoBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getInfo()
        binding.goToTestButton.setOnClickListener { inputValidation() }
    }

    private fun getInfo() {

        ageText = binding.ageMons.text.toString().toIntOrNull()

        binding.radioGroupGender.setOnCheckedChangeListener { radioGroup, selected ->

            sex = when(selected){
                R.id.femaleRadio -> 1
                else -> 0
            }
        }
    }


    private fun inputValidation(){

        getInfo()

        allSelected = binding.radioGroupGender.checkedRadioButtonId != -1

        validationError = when {
            !allSelected -> "اكمل البيانات !"
            ageText == null -> "ادخل  العمر !"
            else -> " العمر يجب أن يكون بين 3 إلي 17 سنة !"
        }

        if ((ageText != null) && (ageText in (3..17)) && allSelected) {
            age = ageText as Int

            ConnersResultFragment.age = age
            ConnersResultFragment.sex = sex

            findNavController().navigate(R.id.action_connersInfoFragment_to_connersTestFragment)
        }else {
            Toast.makeText(context, validationError, Toast.LENGTH_SHORT).show()
        }
    }

    companion object {

    }
}