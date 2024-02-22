package com.example.mente.LearningDifficulties.Parent.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mente.R
import com.example.mente.databinding.FragmentParentTestsBinding


class ParentTestsFragment : Fragment() {


    lateinit var binding: FragmentParentTestsBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentParentTestsBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGoToLearningDifficultiesParent.setOnClickListener {
            findNavController().navigate(R.id.action_parentTestsFragment_to_testsFragment)
        }


        binding.btnGoToAutismParent.setOnClickListener {
            findNavController().navigate(R.id.action_parentTestsFragment_to_parentAutismFragment)

        }

        binding.btnGoToAdhdParent.setOnClickListener {
            findNavController().navigate(R.id.action_parentTestsFragment_to_parentAdhdFragment)
        }
    }


    companion object {

    }
}