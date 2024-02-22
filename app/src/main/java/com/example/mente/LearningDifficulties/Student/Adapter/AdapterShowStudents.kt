package com.example.mente.Student.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mente.ADHD.UI.ConnersResultFragment
import com.example.mente.ADHD.UI.ConnersTestFragment
import com.example.mente.ADHD.UI.StaticAdhdResultFragment
import com.example.mente.ADHD.UI.StaticAdhdTestFragment
import com.example.mente.Autism.Specialist.ui.CarsAutismTestFragment
import com.example.mente.Autism.Specialist.ui.CarsResultFragment
import com.example.mente.Autism.Specialist.ui.GilamResultFragment
import com.example.mente.Autism.Specialist.ui.GilamTestFragment
import com.example.mente.R
import com.example.mente.Specialist.ui.Questions.Evaluation.EvaluationMichealBest
import com.example.mente.Specialist.ui.Questions.Evaluation.EvaluationNeuralScreeningFragment
import com.example.mente.Specialist.ui.Questions.Evaluation.EvaluationSpeElIIinoiFragment
import com.example.mente.Specialist.ui.Questions.Evaluation.EvaluatonFathyElZayatFragment
import com.example.mente.Specialist.ui.Questions.IlllionsQ.*
import com.example.mente.Student.Model.Student
import com.example.mente.Student.View.AddStudentFragment
import com.example.mente.constant
import com.example.mente.databinding.RowStudentBinding

class AdapterShowStudents : RecyclerView.Adapter<AdapterShowStudents.StudentVH>() {
    lateinit var context: Context
    var listStudent: MutableList<Student> = mutableListOf()
    var quizCategory = ""
    var testName = ""


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentVH {
        context = parent.context
        return StudentVH(
            RowStudentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: StudentVH, position: Int) {
        var current = listStudent[position]
        holder.tvStudentName.text = current.name

        holder.itemView.setOnClickListener {

            defineCategoryAndGetActionToNextPage(it, current)
//            EvaluationSpeNeuralFragment.currentStudent = current
//            it.findNavController().navigate(R.id.action_addStudentFragment_to_showQSupportkFragment)
        }

    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

    fun setListOrders(list: MutableList<Student>) {
        this.listStudent = list
        notifyDataSetChanged()
    }


    class StudentVH(item: RowStudentBinding) : RecyclerView.ViewHolder(item.root) {

        var tvStudentName = item.tvRowStudentName
    }


    private fun defineCategoryAndGetActionToNextPage(fabView: View?, currentStudent: Student) {
        when (AddStudentFragment.quizCategory) {
             constant.quizTypeSpeNeural -> {
                 fabView?.findNavController()
                    ?.navigate(R.id.action_addStudentFragment_to_neuralScreeningFragment)

                 EvaluationNeuralScreeningFragment.currentStudent = currentStudent
            }
            ////////////////////////////////////
            constant.quizTypeSpeIIIIinoi -> {


                when (AddStudentFragment.testName) {
                    constant.elIIinoiCategoryList[0] -> {
                        fabView?.findNavController()
                            ?.navigate(R.id.action_addStudentFragment_to_showQTwoAns)
                        EvaluationSpeElIIinoiFragment.currentStudent = currentStudent
                        ShowQIlllioniList1Fragment.student = currentStudent

                    }


                    constant.elIIinoiCategoryList[1] -> {
                        fabView?.findNavController()
                            ?.navigate(R.id.action_addStudentFragment_to_showQIlllioniList2Fragment)
                        EvaluationSpeElIIinoiFragment.currentStudent = currentStudent
                        ShowQIlllioniList2Fragment.student = currentStudent
                    }

                    constant.elIIinoiCategoryList[2] -> {

                        fabView?.findNavController()
                            ?.navigate(R.id.action_addStudentFragment_to_showQIlllioniList3Fragment)
                        EvaluationSpeElIIinoiFragment.currentStudent = currentStudent
                        ShowQIlllioniList3Fragment.student = currentStudent

                    }
                    constant.elIIinoiCategoryList[3] -> {
                        fabView?.findNavController()
                            ?.navigate(R.id.action_addStudentFragment_to_showQIlllioniList4Fragment)
                        EvaluationSpeElIIinoiFragment.currentStudent = currentStudent
                        ShowQIlllioniList4Fragment.student = currentStudent


                    }

                    constant.elIIinoiCategoryList[4] -> {
                        fabView?.findNavController()
                            ?.navigate(R.id.action_addStudentFragment_to_showQIlllioniList5Fragment)
                        EvaluationSpeElIIinoiFragment.currentStudent = currentStudent
                        ShowQIlllioniList5Fragment.student = currentStudent

                    }
                    constant.elIIinoiCategoryList[5] -> {
                        fabView?.findNavController()
                            ?.navigate(R.id.action_addStudentFragment_to_showQIlllioniList6Fragment)
                        EvaluationSpeElIIinoiFragment.currentStudent = currentStudent
                        ShowQIlllioniList6Fragment.student = currentStudent


                    }


                    constant.elIIinoiCategoryList[6] -> {
                        fabView?.findNavController()
                            ?.navigate(R.id.action_addStudentFragment_to_showQIlllioniList7Fragment)
                        EvaluationSpeElIIinoiFragment.currentStudent = currentStudent
                        ShowQIlllioniList7Fragment.student = currentStudent
                    }


                    constant.elIIinoiCategoryList[7] -> {
                        fabView?.findNavController()
                            ?.navigate(R.id.action_addStudentFragment_to_showQIlllioniList8Fragment)
                        EvaluationSpeElIIinoiFragment.currentStudent = currentStudent
                        ShowQIlllioniList8Fragment.student = currentStudent

                    }


                    constant.elIIinoiCategoryList[8] -> {
                        fabView?.findNavController()
                            ?.navigate(R.id.action_addStudentFragment_to_showQIlllioniList9Fragment)
                        EvaluationSpeElIIinoiFragment.currentStudent = currentStudent
                        ShowQIlllioniList9Fragment.student = currentStudent
                    }


                    constant.elIIinoiCategoryList[9] -> {
                        fabView?.findNavController()
                            ?.navigate(R.id.action_addStudentFragment_to_showQIlllioniList10Fragment)
                        EvaluationSpeElIIinoiFragment.currentStudent = currentStudent
                        ShowQIlllioniList10Fragment.student = currentStudent
                    }


                    constant.elIIinoiCategoryList[10] -> {
                        fabView?.findNavController()
                            ?.navigate(R.id.action_addStudentFragment_to_showQIlllioniList11Fragment)
                        EvaluationSpeElIIinoiFragment.currentStudent = currentStudent
                        ShowQIlllioniList11Fragment.student = currentStudent

                    }


                    constant.elIIinoiCategoryList[11] -> {
                        fabView?.findNavController()
                            ?.navigate(R.id.action_addStudentFragment_to_showQIlllioniList12Fragment)
                        EvaluationSpeElIIinoiFragment.currentStudent = currentStudent
                        ShowQIlllioniList12Fragment.student = currentStudent


                    }




                }
            }


            ///////////////////
            constant.quizTypeSpeFathyElZayat -> {
                fabView?.findNavController()
                    ?.navigate(R.id.action_addStudentFragment_to_showQFourAnsFragment)

                EvaluatonFathyElZayatFragment.currentStudent = currentStudent
            }

            constant.quizTypeSpeMichaelBest -> {
                fabView?.findNavController()
                    ?.navigate(R.id.action_addStudentFragment_to_QSpeMichaelType)
                EvaluationMichealBest.currentStudent = currentStudent

            }

            constant.btnGoToGilamQ -> {
                GilamTestFragment.student= currentStudent
                GilamResultFragment.currentStudent = currentStudent
                fabView?.findNavController()
                    ?.navigate(R.id.action_addStudentFragment2_to_gilamTestFragment)

            }



            constant.btnGoTocars-> {
                fabView?.findNavController()
                    ?.navigate(R.id.action_addStudentFragment2_to_carsAutismTestFragment)
                CarsResultFragment.student = currentStudent
                CarsAutismTestFragment.student = currentStudent
            }

            constant.btnGoToStaticADHDQ-> {
                fabView?.findNavController()
                    ?.navigate(R.id.action_addStudentFragment3_to_staticAdhdTestFragment)
                StaticAdhdResultFragment.currentStudent = currentStudent
                StaticAdhdTestFragment.student = currentStudent
            }

            constant.btnGoToConnersQ-> {
                fabView?.findNavController()
                    ?.navigate(R.id.action_addStudentFragment3_to_connersInfoFragment)
                ConnersResultFragment.currentStudent = currentStudent
                ConnersTestFragment.student = currentStudent
            }


        }
    }


    companion object {

        private var instance: AdapterShowStudents? = null

        fun getInstance(): AdapterShowStudents {

            if (instance == null) {
                instance = AdapterShowStudents()
            }
            return instance!!
        }


    }

}