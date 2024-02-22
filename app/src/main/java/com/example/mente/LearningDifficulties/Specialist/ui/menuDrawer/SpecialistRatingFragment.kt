package com.example.mente.Specialist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mente.Specialist.HomeSpecialistActivity
import com.example.mente.databinding.FragmentRatingSpecialistBinding

class RatingFragment : Fragment() {

    private lateinit var binding: FragmentRatingSpecialistBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRatingSpecialistBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setActionBar()

    }



    private fun setActionBar() {
        var act = activity as HomeSpecialistActivity
        act.supportActionBar?.title = "Rating Page"
    }
}