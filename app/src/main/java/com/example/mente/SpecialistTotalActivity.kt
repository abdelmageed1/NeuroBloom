package com.example.mente

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.mente.ADHD.AdhdHomeActivity
import com.example.mente.Autism.Specialist.AutismHomeActivity
import com.example.mente.Specialist.HomeSpecialistActivity
import com.example.mente.databinding.ActivitySpecialistTotalBinding

class SpecialistTotalActivity : AppCompatActivity() {

    lateinit var binding: ActivitySpecialistTotalBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySpecialistTotalBinding.inflate(layoutInflater)

        window.decorView.layoutDirection = View.LAYOUT_DIRECTION_RTL

        setContentView(binding.root)


        binding.btnGoToLearningDifficulties.setOnClickListener {
            var intent = Intent(this, HomeSpecialistActivity::class.java)
            startActivity(intent)


        }

        binding.btnGoToAutism.setOnClickListener {
            var intent = Intent(this, AutismHomeActivity::class.java)
            startActivity(intent)

        }

        binding.btnGoToAdhd.setOnClickListener {
            val intent = Intent(this, AdhdHomeActivity::class.java)
            startActivity(intent)
        }
        window.statusBarColor = ContextCompat.getColor(this, R.color.base_color)

    }

}