package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        var binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
//        val binding:ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
      binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Timber.plant(Timber.DebugTree())

        setSupportActionBar(binding.toolbar)
        val navController  = this.findNavController((R.id.frag_host))
        NavigationUI.setupActionBarWithNavController(this,navController)

    }

    override fun onSupportNavigateUp(): Boolean {
//        val navController = this.findNavController(R.id.frag_host)
//
//        return navController.navigateUp()
        onBackPressed()
        return true
    }

}
