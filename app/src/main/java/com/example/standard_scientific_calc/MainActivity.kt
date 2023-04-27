package com.example.standard_scientific_calc

import BasicCalculatorFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.calculator_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.basic_calculator_option -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, BasicCalculatorFragment())
                    .commit()
                return true
            }
            R.id.scientific_calculator_option -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, ScientificCalculatorFragment())
                    .commit()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}