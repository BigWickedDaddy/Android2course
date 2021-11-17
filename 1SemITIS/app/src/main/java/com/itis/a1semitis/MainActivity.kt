package com.itis.a1semitis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.itis.a1semitis.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    var people: ArrayList<Person> = ArrayList()
    var pictures: ArrayList<Int> = arrayListOf(R.drawable.person1,
        R.drawable.person2, R.drawable.person3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavController()
    }

    private fun initNavController() {
        navController =
            (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment).navController
        setupActionBarWithNavController(navController, AppBarConfiguration(setOf(R.id.firstFragment, R.id.secondFragment, R.id.thirdFragment)))
        binding.bottomMenu.setupWithNavController(navController)
    }


}