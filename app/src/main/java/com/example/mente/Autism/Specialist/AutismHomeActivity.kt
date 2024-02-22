package com.example.mente.Autism.Specialist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.mente.R
import com.example.mente.databinding.ActivityAutismHomeBinding

class AutismHomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityAutismHomeBinding
//    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAutismHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        

//        val navHostFragment = supportFragmentManager
//            .findFragmentById(R.id.nav_view_home_autism) as NavHostFragment
//        navController = navHostFragment.navController
//


        window.statusBarColor = ContextCompat.getColor(this,R.color.base_color)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }



}