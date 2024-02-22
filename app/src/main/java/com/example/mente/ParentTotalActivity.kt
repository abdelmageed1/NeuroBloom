package com.example.mente

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ParentTotalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.layoutDirection = View.LAYOUT_DIRECTION_RTL

        setContentView(R.layout.activity_parent_total)







    }
}