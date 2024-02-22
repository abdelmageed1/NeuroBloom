package com.example.mente.Specialist.ui.history.repo

import androidx.lifecycle.MutableLiveData
import com.example.mente.Models.Quiz
import com.example.mente.constant
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class RepoResultOfQuiz {

    var mQuiz = MutableLiveData<MutableList<Quiz>>()
    var mParentQuiz = MutableLiveData<MutableList<Quiz>>()

    private var auth = Firebase.auth
    var refStudent = Firebase.database.reference.child("Users")
       .child("${auth.currentUser?.uid}").child("Students")




    fun getQuizResult(studentId: String ,category_id :Int ,categoryName: String ) {
        var category = ""

        when(category_id){
            1 -> category = constant.quizTypeSpeNeural
            2 -> category = constant.quizTypeSpeIIIIinoi
            3 -> category = constant.quizTypeSpeFathyElZayat
            4 -> category = constant.quizTypeSpeMichaelBest
            5 -> category = constant.quizTypecars
            6 -> category = constant.quizTypgilam
            7-> category = constant.quizTypeadhaDR
            8 -> category = constant.quizTypeconares

        }

        var quiz = mutableListOf<Quiz>()
        refStudent.child(studentId).child("Quizzes").child(categoryName).child(category).addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                quiz.clear()
                for (child in snapshot.children) {
                    quiz.add(child.getValue(Quiz::class.java)!! as Quiz)
                }
                mQuiz.postValue(quiz)

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }


    fun getQuizParentResult(){
        var quiz = mutableListOf<Quiz>()
        Firebase.database.reference.child("Users")
            .child("${auth.currentUser?.uid}").child("Student")
            .addValueEventListener(object :
            ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {

                    quiz.clear()
                    for (child in snapshot.children) {
                        quiz.add(child.getValue(Quiz::class.java)!! as Quiz)
                    }
                    mParentQuiz.postValue(quiz)
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
    }


  fun removeQuiz(quiz: Quiz ,studentId :String){
//      refStudent.child(studentId).child("Quizzes").child(quiz.categoryQuiz)
//          .child(quiz.nameQuiz).removeValue()
    }

  fun removeQuizParent(quiz: Quiz){
      Firebase.database.reference.child("Users")
          .child("${auth.currentUser?.uid}").child("Student").child(quiz.nameQuiz).removeValue()
    }


    companion object {
        private var instance: RepoResultOfQuiz? = null

        fun getInstance(): RepoResultOfQuiz {
            if (instance == null) {
                instance = RepoResultOfQuiz()
            }
            return instance!!
        }
    }
}