package com.example.mente.Specialist.ui.history.View

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mente.Models.Quiz
import com.example.mente.R
import com.example.mente.Specialist.HomeSpecialistActivity
import com.example.mente.Specialist.ui.history.ViewModel.QuizResultVM
import com.example.mente.Specialist.ui.history.adapter.AdapterShowQuizResult
import com.example.mente.Student.Model.Student
import com.example.mente.Student.Repo.RepoStudent
import com.example.mente.constant
import com.example.mente.databinding.FragmentShowRowOfHistoryBinding


class ShowRowOfHistoryFragment : Fragment() {
    lateinit var binding: FragmentShowRowOfHistoryBinding

    lateinit var quizResultVM: QuizResultVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        quizResultVM = ViewModelProvider(this)[QuizResultVM::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowRowOfHistoryBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       selectCategory()
        setViews()

        RemoveStudent()

    }

    @SuppressLint("SuspiciousIndentation")
    private fun RemoveStudent() {
        binding.btnRemoveStudent.setOnClickListener {

            var builder = AlertDialog.Builder(context)
              builder.apply {
                setTitle("تنبيه ")
                setIcon(R.drawable.logo)
                setMessage("هل انت متأكد من حذف هذالطالب")
                setPositiveButton("yes", DialogInterface.OnClickListener { dialog, which ->
                    // delete
                    RepoStudent.getInstance().removeStudent(student.key)
//                    findNavController().navigate(R.id.action_showRowOfHistoryFragment_to_historyStudentFragment)
                })

                setCancelable(true)
                show()


                // navigate the previous page
            }
        }
    }


    private fun selectCategory() {
                     when (id_q) {
                        1-> {
                             quizResultVM.getResultQuiz(student.key, 1 , constant.quizTypeDiff)
                            setQuizFromDBToRecycle()
                        }
                       2 -> {
                             quizResultVM.getResultQuiz(student.key , 2,constant.quizTypeDiff)
                           setQuizFromDBToRecycle()
                        }
                        3 -> {
                             quizResultVM.getResultQuiz(student.key ,3 ,constant.quizTypeDiff)
                            setQuizFromDBToRecycle()
                        }
                        4 -> {
                             quizResultVM.getResultQuiz(student.key , 4 ,constant.quizTypeDiff)
                            setQuizFromDBToRecycle()
                        }
                        5 -> {
                             quizResultVM.getResultQuiz(student.key , 5 ,constant.quizTypeAutism)
                            setQuizFromDBToRecycle()
                        }  6 -> {
                             quizResultVM.getResultQuiz(student.key , 6 ,constant.quizTypeAutism)
                            setQuizFromDBToRecycle()
                        } 7-> {
                             quizResultVM.getResultQuiz(student.key , 7 ,constant.quizTypeAdhd)
                            setQuizFromDBToRecycle()
                        } 8 -> {
                             quizResultVM.getResultQuiz(student.key , 8 ,constant.quizTypeAdhd)
                            setQuizFromDBToRecycle()
                        }
                    }

    }

    private fun setQuizFromDBToRecycle() {
        quizResultVM.mGetQuiz.observe(viewLifecycleOwner) {
            if (it != null) {
                setRecycle(it)

                if (it.size == 0) {
                      binding.tvStudentIsEmpty.visibility = View.VISIBLE

                }
                else {binding.tvStudentIsEmpty.visibility = View.GONE}
            }
        }
    }

    private fun setViews() {
        binding.tvStudentName.text = "الاسم : ${student.name}"
        binding.tvStudentAge.text = "السن : ${student.ageStr}"

    }

    private fun setRecycle(it: MutableList<Quiz>) {
        var adapterQuiz = AdapterShowQuizResult.getInstance()
        binding.rvQuizResult.layoutManager = LinearLayoutManager(context)
        binding.rvQuizResult.adapter = adapterQuiz
        adapterQuiz.studentId = student.key
        adapterQuiz.setListOrders(it)

    }




    companion object {
        lateinit var student : Student
         var id_q :Int = 0



    }
}