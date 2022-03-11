package com.kiwi.chat

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.content.Intent
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.kiwi.chat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    private lateinit var binding: ActivityMainBinding
    val personResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){  result->
        Log.d(TAG, "back from LoginActivity with data?")
    }

    val homeResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){  result->
        Log.d(TAG, "back from homeActivity with data?")
    }

    val searchResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){  result->
        Log.d(TAG, "back from searchActivity with data?")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //button function

        setupFunctions()

    }

    private fun setupFunctions() {
        binding.bPerson.setOnClickListener(){
            personResultLauncher.launch(
                Intent(this, LoginActivity::class.java)
            )
        }

        binding.bHome.setOnClickListener(){
            homeResultLauncher.launch(
                Intent(this, MainActivity::class.java)
            )
        }

        binding.bSearch.setOnClickListener(){
            searchResultLauncher.launch(
                Intent(this, SearchActivity::class.java)
            )
        }
    }

}