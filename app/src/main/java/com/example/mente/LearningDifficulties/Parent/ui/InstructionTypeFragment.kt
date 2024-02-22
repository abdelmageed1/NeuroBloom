package com.example.mente.LearningDifficulties.Parent.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mente.Parent.ui.instruction.InstructionFragment
import com.example.mente.R
import com.example.mente.databinding.FragmentInstructionTypeBinding


class InstructionTypeFragment : Fragment() {


    lateinit var binding: FragmentInstructionTypeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInstructionTypeBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonDiff.setOnClickListener {
            InstructionFragment.testType = "diff"
            findNavController().navigate(R.id.action_instructionTypeFragment_to_instructionFragment)
        }

        binding.buttonAdhd.setOnClickListener {
            InstructionFragment.testType = "adhd"
            findNavController().navigate(R.id.action_instructionTypeFragment_to_instructionFragment)
        }

        binding.buttonAutism.setOnClickListener {
            InstructionFragment.testType = "autism"
            findNavController().navigate(R.id.action_instructionTypeFragment_to_instructionFragment)
        }
    }


    companion object {

    }
}