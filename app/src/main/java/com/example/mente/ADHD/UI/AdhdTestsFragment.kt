package com.example.mente.ADHD.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mente.R
import com.example.mente.Student.View.AddStudentFragment
import com.example.mente.constant
import com.example.mente.databinding.FragmentAdhdTestsBinding


class AdhdTestsFragment : Fragment() {

    private lateinit var binding : FragmentAdhdTestsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAdhdTestsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.btnGoToMentalHealth.setOnClickListener {
//               findNavController().navigate(R.id.action_adhdTestsFragment_to_mentalHealthInfoFragment)
//        }

        binding.btnGoToAdhd.setOnClickListener {
             AddStudentFragment.testName  = constant.btnGoToStaticADHDQ
             AddStudentFragment.quizCategory  = constant.btnGoToStaticADHDQ
            findNavController().navigate(R.id.action_adhdTestsFragment_to_addStudentFragment3)

        }

        binding.btnGoToConners.setOnClickListener {
            AddStudentFragment.testName  = constant.btnGoToConnersQ
            AddStudentFragment.quizCategory  = constant.btnGoToConnersQ
            findNavController().navigate(R.id.action_adhdTestsFragment_to_addStudentFragment3)
        }
    }
}


//CarsAutismTestFragment.categoryQuestion = constant.btnGoTocars
//AddStudentFragment.testName  = constant.btnGoTocars
//AddStudentFragment.quizCategory  = constant.btnGoTocars
//findNavController().navigate(R.id.action_homeAutismFragment_to_addStudentFragment2)
//