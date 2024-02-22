package com.example.mente.LearningDifficulties

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mente.Authentication.AuthenticationViewModel.AuthVM
import com.example.mente.Authentication.Ui.Login
import com.example.mente.R
import com.example.mente.databinding.ActivitySpecialistMainBinding
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SpecialistMainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySpecialistMainBinding
    lateinit var authVM: AuthVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySpecialistMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        window.statusBarColor = ContextCompat.getColor(this,R.color.base_color)
        window.decorView.layoutDirection = View.LAYOUT_DIRECTION_RTL

        authVM = ViewModelProvider(this)[AuthVM::class.java]
        authVM.getUserInfo()

        // set Navigation Drawer


        setUserNameInNavHeader()

        setSupportActionBar(binding.appBarSpecialistMain.toolbar)

//        binding.appBarSpecialistMain.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_specialist_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.nav_home, R.id.aboutUsFragment, R.id.historyStudentFragment
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        navView.menu.findItem(R.id.settingFragment).setOnMenuItemClickListener {
            signOut()
            true
        }
    }


    private fun signOut(){
        startActivity(Intent(this, Login::class.java))
        this.finish()
        Firebase.auth.signOut()
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.specialist_main, menu)
//        return true
//    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_specialist_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    private fun setUserNameInNavHeader() {

        var n = binding.navView.getHeaderView(0)
        var userName = n.findViewById<TextView>(R.id.tvUserNameInDrawer)
        var userEmail = n.findViewById<TextView>(R.id.tvUserEmailInDrawer)
        authVM.mGetUserInfo.observe(this) {
            if (it != null)
            {
                userName.text = "${it.fName.capitalize()} ${it.lName.capitalize()}"
                userEmail.text = " ${it.email}"
            }


        }

    }
}