package com.example.mente.LearningDifficulties.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mente.ADHD.AdhdHomeActivity
import com.example.mente.Autism.Specialist.AutismHomeActivity
import com.example.mente.LearningDifficulties.SpecialistMainActivity
import com.example.mente.Specialist.HomeSpecialistActivity
import com.example.mente.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ac = activity

        binding.btnGoToLearningDifficulties.setOnClickListener {
            var intent = Intent(ac!!.baseContext, HomeSpecialistActivity::class.java)
            startActivity(intent)


        }

        binding.btnGoToAutism.setOnClickListener {
            var intent = Intent(ac!!.baseContext, AutismHomeActivity::class.java)
            startActivity(intent)

        }

        binding.btnGoToAdhd.setOnClickListener {
            val intent = Intent(ac!!.baseContext, AdhdHomeActivity::class.java)
            startActivity(intent)
        }


//        ac.window.statusBarColor = ContextCompat.getColor(ac.baseContext, R.color.base_color)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}