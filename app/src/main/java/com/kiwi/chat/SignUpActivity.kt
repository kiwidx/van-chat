package com.kiwi.chat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.kiwi.chat.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private val TAG = ActivitySignUpBinding::class.java.simpleName
    private lateinit var binding: ActivitySignUpBinding


    var signup_state: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate: signup")

    }
    fun signup(view: View){
        var supname = binding.edSignname.text.toString()
        var suppass = binding.edSignpass.text.toString()
        val checkedId = CheckNum(supname)
        val checkedPass = CheckNum(suppass)
        var errormeg: String = ""
        binding.bSend.setOnClickListener(){
            errormeg = when{
                checkedId.userId() == CheckNum.NumSignState.TOOLONG -> "Id is too long."
                checkedId.userId() == CheckNum.NumSignState.TOOSHORT -> "Id is too short."
                checkedPass.userPass() == CheckNum.NumSignState.TOOLONG -> "Password is too long."
                checkedPass.userPass() == CheckNum.NumSignState.TOOSHORT -> "Password is too short."
                else -> "OK"
            }
            if (errormeg == "OK"){
                signup_state = true
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("username", checkedId.userId())
                startActivity(intent)
                Log.d(TAG, "SignUp: success")
            }else{
                AlertDialog.Builder(this)
                    .setTitle("Wrong Message")
                    .setMessage(errormeg)
                    .setPositiveButton("Ok", null)
                    .show()
            }
            finish()
        }
    }
}