package com.example.mente.Autism.Specialist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mente.R
import com.example.mente.Specialist.ui.Questions.fathyElZayat.ShowQFourAnsFragment
import com.example.mente.Student.View.AddStudentFragment
import com.example.mente.constant
import com.example.mente.databinding.FragmentHomeAutismBinding


class HomeAutismFragment : Fragment() {

     lateinit var binding: FragmentHomeAutismBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeAutismBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.btnGoToQChat10.setOnClickListener {
//            findNavController().navigate(R.id.action_homeAutismFragment_to_evaluationAutismFragment)
//        }

        binding.btnGoToCars.setOnClickListener {

            CarsAutismTestFragment.categoryQuestion = constant.btnGoTocars
            AddStudentFragment.testName  = constant.btnGoTocars
            AddStudentFragment.quizCategory  = constant.btnGoTocars
            findNavController().navigate(R.id.action_homeAutismFragment_to_addStudentFragment2)
        }

        binding.btnGoToGilam.setOnClickListener {

            GilamTestFragment.categoryQuestion = constant.btnGoToGilamQ
            AddStudentFragment.testName  = constant.btnGoToGilamQ
            AddStudentFragment.quizCategory  = constant.btnGoToGilamQ
            findNavController().navigate(R.id.action_homeAutismFragment_to_addStudentFragment2)
        }
    }

    companion object {
        lateinit var typeBtnQuestions: String

    }
}