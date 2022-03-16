package com.kiwi.chat

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.kiwi.chat.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val TAG = SignUpActivity::class.java.simpleName
    private lateinit var binding: ActivityLoginBinding
    private val signUpResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){ result->
        Log.d(TAG, "back from SignUpActivity with data?")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_login)
        setContentView(binding.root)
        login()
        signUp()
    }

    private fun signUp(){
        binding.bSignup.setOnClickListener {
            signUpResultLauncher.launch(
                Intent(this, SignUpActivity::class.java)
            )
        }
    }
    private fun login(){
        var uname: String = binding.edUsername.text.toString()
        var upass: String = binding.edPassword.text.toString()
        var sign = signUp()
        Log.d(TAG, "Username: $uname")
        Log.d(TAG, "Userpass: $upass")

    }
}