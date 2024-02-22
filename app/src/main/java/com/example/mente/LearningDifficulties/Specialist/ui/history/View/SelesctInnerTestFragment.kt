package com.example.mente.LearningDifficulties.Specialist.ui.history.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mente.R
import com.example.mente.Specialist.ui.history.View.ShowRowOfHistoryFragment
import com.example.mente.Student.Model.Student
import com.example.mente.databinding.FragmentSelectTestBinding
import com.example.mente.databinding.FragmentSelesctInnerTestBinding

class SelesctInnerTestFragment : Fragment() {
    lateinit var binding : FragmentSelesctInnerTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelesctInnerTestBinding.inflate(inflater ,container ,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ShowRowOfHistoryFragment.student = student


       if (type == "adhd"){


           binding.lin1.visibility = View.GONE
           binding.lin2.visibility = View.GONE
           binding.lin3.visibility = View.VISIBLE


       }
           if (type == "autism"){
               binding.lin1.visibility = View.GONE
               binding.lin2.visibility = View.VISIBLE
               binding.lin3.visibility = View.GONE
           }
           if (type == "diff"){
               binding.lin1.visibility = View.VISIBLE
               binding.lin2.visibility = View.GONE
               binding.lin3.visibility = View.GONE
       }


        binding.btnNeuron.setOnClickListener {
            ShowRowOfHistoryFragment.id_q = 1
            findNavController().navigate(R.id.action_selesctInnerTestFragment_to_showRowOfHistoryFragment )
        }


        binding.btnElioni.setOnClickListener {
            ShowRowOfHistoryFragment.id_q = 2
            findNavController().navigate(R.id.action_selesctInnerTestFragment_to_showRowOfHistoryFragment )
        }


        binding.btnFathy.setOnClickListener {
            ShowRowOfHistoryFragment.id_q = 3
            findNavController().navigate(R.id.action_selesctInnerTestFragment_to_showRowOfHistoryFragment )
        }

          binding.btnMaichel.setOnClickListener {
            ShowRowOfHistoryFragment.id_q =4
            findNavController().navigate(R.id.action_selesctInnerTestFragment_to_showRowOfHistoryFragment )
        }

        binding.btnAutism1.setOnClickListener {
            ShowRowOfHistoryFragment.id_q = 5
            findNavController().navigate(R.id.action_selesctInnerTestFragment_to_showRowOfHistoryFragment )
        }

        binding.btnAutism2.setOnClickListener {
            ShowRowOfHistoryFragment.id_q = 6
            findNavController().navigate(R.id.action_selesctInnerTestFragment_to_showRowOfHistoryFragment )
        }


        binding.btnAdhd1.setOnClickListener {
            ShowRowOfHistoryFragment.id_q = 7
            findNavController().navigate(R.id.action_selesctInnerTestFragment_to_showRowOfHistoryFragment )
        }
          binding.btnAdhd2.setOnClickListener {
            ShowRowOfHistoryFragment.id_q = 8
            findNavController().navigate(R.id.action_selesctInnerTestFragment_to_showRowOfHistoryFragment )
        }











    }




    companion object {
        lateinit var type : String
        lateinit var student : Student
    }
}