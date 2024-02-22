package com.example.mente.LearningDifficulties.Parent.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mente.R
import com.example.mente.databinding.FragmentParentAutismBinding


class ParentAutismFragment : Fragment() {

    lateinit var binding: FragmentParentAutismBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGoToQChat10Parent.setOnClickListener {
            findNavController().navigate(R.id.action_parentAutismFragment_to_evaluationAutismFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentParentAutismBinding.inflate(inflater,container,false)
        return binding.root
    }




    companion object {

    }
}