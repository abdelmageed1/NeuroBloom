package com.example.mente.ADHD.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mente.R
import com.example.mente.databinding.FragmentMentalHealthInfoBinding


class MentalHealthInfoFragment : Fragment() {

    private lateinit var binding : FragmentMentalHealthInfoBinding
    private var ageMonths = 0
    private var ageInput: Int? = 0
    private var validationError = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMentalHealthInfoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getInput()
        binding.startBtn.setOnClickListener { ageValidation() }
    }


    private fun getInput(){
        ageInput = binding.adhdAge.text.toString().toIntOrNull()
    }


    private fun ageValidation(){

        getInput()

        validationError = when (ageInput) {
            null -> "ادخل أشهر العمر !"
            else -> " العمر يجب أن يكون بين 4 إلي 46 شهر !"
        }

        if(ageInput !=null && (ageInput in (4..46))){
            ageMonths = ageInput as Int
            MentalHealthTestFragment.listAnswers.add(0,ageMonths)
            findNavController().navigate(R.id.action_mentalHealthInfoFragment_to_mentalHealthTestFragment)
        }else{
            Toast.makeText(context, validationError, Toast.LENGTH_SHORT).show()
        }
    }
}