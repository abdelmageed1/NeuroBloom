package com.example.mente.Specialist.ui.history.ViewModel

import androidx.lifecycle.ViewModel
import com.example.mente.Specialist.ui.history.repo.RepoResultOfQuiz

class QuizResultVM  : ViewModel() {


     var repoQuiz = RepoResultOfQuiz.getInstance()

    var  mGetQuiz = repoQuiz.mQuiz
    var  mGetQuizParent = repoQuiz.mParentQuiz


    fun getResultQuiz(studentId :String , categor_id : Int , category :String) {
        repoQuiz.getQuizResult(studentId , categor_id ,category )
    }

    fun getResultParentQuiz(){
        repoQuiz.getQuizParentResult()
    }



}