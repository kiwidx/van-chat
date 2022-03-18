package com.kiwi.chat

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
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
        setContentView(binding.root)
        val username = intent.getStringExtra("name")
        binding.data.setText(username.toString())
        signUp()
    }

    override fun onCreateView(
        parent: View?,
        name: String,
        context: Context,
        attrs: AttributeSet
    ): View? {
        return super.onCreateView(parent, name, context, attrs)
    }

    private fun signUp(){
        binding.bSignup.setOnClickListener {
            signUpResultLauncher.launch(
                Intent(this, SignUpActivity::class.java)
            )
        }
    }
    private fun login(){

    }
}