package com.example.mente.ADHD

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.mente.R
import com.example.mente.databinding.ActivityAdhdHomeBinding

class AdhdHomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAdhdHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdhdHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this,R.color.base_color)
    }
}