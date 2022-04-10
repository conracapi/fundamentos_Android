package com.example.avengersapp.activity

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.avengersapp.R
import com.example.avengersapp.fragment.MainVillainsFragment
import com.example.avengersapp.fragment.MainHeroesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : FragmentActivity() {

    // BottomNavigation
    private lateinit var bottomNavigation: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setViews()
        configureViewListener()
        getHeroesFragment()
    }

    // Configuración de vistas
    private fun setViews () {
        bottomNavigation = findViewById(R.id.bottomNavigation)
    }


    private fun configureViewListener () {
        bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menuVillains -> {
                    getVillainsFragment()
                    true
                }
                R.id.menuHeroes -> {
                    getHeroesFragment()
                    true
                }
                else -> false
            }

        }
    }

    private fun getHeroesFragment () {
        supportFragmentManager.beginTransaction().replace(R.id.container_fragment, MainHeroesFragment.newInstance()).commit()
    }

    private fun getVillainsFragment () {
        supportFragmentManager.beginTransaction().replace(R.id.container_fragment, MainVillainsFragment.newInstance()).commit()
    }


}