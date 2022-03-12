package com.kiwi.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kiwi.chat.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    companion object{
        private val TAG = ActivitySignUpBinding::class.java.simpleName
    }
    lateinit var binding: ActivitySignUpBinding
    var signup_state: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate: signup")
        binding.bCheckSignup.setOnClickListener(){
            var supname = binding.edUsernameSignup.text.toString()
            var suppass = binding.edPasswordSignup.text.toString()
            val checkedId = CheckNum(supname)
            val checkedPass = CheckNum(suppass)

            var errormeg: String = ""
            errormeg = when{
                checkedId.userId() == CheckNum.NumSignState.TOOLONG -> "Id is too long."
                checkedId.userId() == CheckNum.NumSignState.TOOSHORT -> "Id is too short."
                checkedPass.userPass() == CheckNum.NumSignState.TOOLONG -> "Password is too long."
                checkedPass.userPass() == CheckNum.NumSignState.TOOSHORT -> "Password is too short."
                ((checkedId.userId() == CheckNum.NumSignState.OK) && (checkedPass.userPass() == CheckNum.NumSignState.OK))->"Sign up Success"
                else -> "Wrong"
            }
            if (errormeg == "OK"){
                signup_state = true
                Log.d(TAG, "SignUp: success")
            }else{
                AlertDialog.Builder(this)
                    .setTitle("Wrong Message")
                    .setMessage(errormeg)
                    .setPositiveButton("Ok", null)
                    .show()
            }
        }

    }
}