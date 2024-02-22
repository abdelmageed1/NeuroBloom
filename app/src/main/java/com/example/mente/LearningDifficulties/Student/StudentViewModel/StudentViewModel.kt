package com.example.mente.Student.StudentViewModel

import androidx.lifecycle.ViewModel
import com.example.mente.Models.Quiz
import com.example.mente.Student.Model.Student
import com.example.mente.Student.Repo.RepoStudent

class StudentViewModel : ViewModel() {

    var studentRepo = RepoStudent.getInstance()
    var mAddStudentSuccess = studentRepo.addedStudentSuccess
    var mAddStudentFailure = studentRepo.addedStudentFailure

    var mSetQuizSuccess = studentRepo.mSetQuizSuccess
    var mSetQuizFailure = studentRepo.mSetQuizFailure

    var mSetQuizParentSuccess = studentRepo.mSetQuizParentSuccess
    var mSetQuizParentFailure = studentRepo.mSetQuizParentFailure
    fun addNewStudent(student: Student) {

        studentRepo.addStudentInfo(student)

    }

    fun getStudent ()
    {
        studentRepo.getStudentInSpecialist()
    }

    fun setQuizValue(quiz: Quiz, student :Student){
        studentRepo.setQuizResult(quiz , student )
    }



    fun setQuizParentValue(quiz: Quiz){
        studentRepo.setQuizResultInParent(quiz )
    }






    fun getMutableStudents() = studentRepo.mStudent

    fun getAlltest() = studentRepo.mTestNeuron

    fun getTestsDNeuron(student: Student){
        studentRepo.getTestsNeuron(student.key)
    }







}