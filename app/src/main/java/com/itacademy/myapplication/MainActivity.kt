package com.itacademy.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.itacademy.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigation.background = null
        setupBottomNavigation()


        val navController = findNavController(R.id.fragment_container)
        binding.fab.setOnClickListener {
            navController.navigateUp()
            navController.navigate(R.id.addBookF)

         }
    }
    private fun setupBottomNavigation(){
        val navController = Navigation.findNavController(this, R.id.fragment_container)
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController)
    }
}