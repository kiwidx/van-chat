package com.kiwi.chat

import android.app.AppComponentFactory
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.kiwi.chat.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    /*var remember = false
    private var _binding: FragmentLayoutbinding? = nullsLast()

    private val binding get() = _binding!!
    //private lateinit var binding: ActivityLoginBinding
    var TAG = ActivityLoginBinding::class.java.simpleName
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = F
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login)
        var username = binding.edUsername.text.toString()
        var password = binding.edPassword.text.toString()
        Log.d(TAG, "USERNAME: $username")
        Log.d(TAG, "PASSWORD: $password")
        binding.bLogin.setOnClickListener{
            //Login staff
            if(username == "kiwi" && password = "1234"){
                if(remember){

                }
            }
        }*/
    private val TAG = SignUpActivity::class.java.simpleName
    private lateinit var binding: ActivityLoginBinding
    val signUpResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){ result->
        Log.d(TAG, "back from SignUpActivity with data?")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_login)
        setContentView(binding.root)
        signUp()
        Log.d(TAG, "signUp: yes")
       binding.sign.setOnClickListener(){
            signUpResultLauncher.launch(
               Intent(this, SignUpActivity::class.java)
            )
       }
    }
    private fun signUp(){

    }

}