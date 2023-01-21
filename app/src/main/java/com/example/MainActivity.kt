package com.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fragmentnavigatsion.R
import com.example.fragmentnavigatsion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
        private lateinit var appBarConfiguration: AppBarConfiguration
        private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.findNavController()

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_serch,
                R.id.nav_setting,
                R.id.nav_reating,
                R.id.nav_camera
            ),
            binding.drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)


        binding.bottomNav.setupWithNavController(navController)
        binding.navView.setupWithNavController(navController)


        navController.addOnDestinationChangedListener { _, destination, argument ->

            if (destination.id == R.id.nav_reating) {
                binding.bottomNav.visibility = View.GONE
            } else if (destination.id == R.id.nav_camera) {
                binding.bottomNav.visibility = View.GONE
            } else {
                binding.bottomNav.visibility = View.VISIBLE
            }


        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}