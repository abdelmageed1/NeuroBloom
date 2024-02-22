package com.example.mente.LearningDifficulties.Specialist.ui.history.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mente.R
import com.example.mente.Student.Model.Student
import com.example.mente.Student.StudentViewModel.StudentViewModel
import com.example.mente.databinding.FragmentHistoryStudentBinding
import com.example.mente.databinding.FragmentSelectTestBinding


class SelectTestFragment : Fragment() {
    lateinit var binding : FragmentSelectTestBinding
//    lateinit var studentViewModel: StudentViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        studentViewModel = ViewModelProvider(this)[StudentViewModel::class.java]

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectTestBinding.inflate(inflater ,container ,false)
        return binding.root
    }






    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        SelesctInnerTestFragment.student = student


        binding.btnAdhd.setOnClickListener{

            findNavController().navigate(R.id.action_selectTestFragment_to_selesctInnerTestFragment )
            SelesctInnerTestFragment.type = "adhd"
        }


          binding.btnAutism.setOnClickListener{

            findNavController().navigate(R.id.action_selectTestFragment_to_selesctInnerTestFragment )
            SelesctInnerTestFragment.type = "autism"
        }


          binding.btnDiff.setOnClickListener{

            findNavController().navigate(R.id.action_selectTestFragment_to_selesctInnerTestFragment )
            SelesctInnerTestFragment.type = "diff"
        }





//        setTestsFromDBToRecycle()

    }

//
//    private fun setTestsFromDBToRecycle() {
//        studentViewModel.getTestsDNeuron(student)
//       studentViewModel.getAlltest().observe(viewLifecycleOwner) {
//
//             if (it != null) {
////                 arrStudent = it
////                setRecycle(it)
//                 Toast.makeText(context, "$it", Toast.LENGTH_SHORT).show()
//
////                 if (it.size == 0) {
////                     binding.tvStudentIsEmpty.visibility = View.VISIBLE
////
//                }
//            }
//        }
//


    companion object {
        lateinit var student : Student

            }
    }
