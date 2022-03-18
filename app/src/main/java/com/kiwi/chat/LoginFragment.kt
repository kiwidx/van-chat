package com.kiwi.chat

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.navigation.fragment.findNavController
import com.kiwi.chat.databinding.FragmentLoginBinding

class LoginFragment : Fragment(){

    var remember = false
    private var _binding: FragmentLoginBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    //fragment_login
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref = requireContext().getSharedPreferences("user", Context.MODE_PRIVATE)
        val checked = pref.getBoolean("rem_username", false)
        binding.cbRemember.isChecked = checked
        binding.cbRemember.setOnCheckedChangeListener{ compoundButton, checked->
            remember = checked
            pref.edit().putBoolean("rem_username", remember).apply()
            if(!checked){
                pref.edit().putString("USER", "").apply()
            }
        }
        val prefUser = pref.getString("USER", "")
        if (prefUser != "") {
            binding.edUsername.setText(prefUser)
        }

        binding.bLogin.setOnClickListener{
            //login
            val username = binding.edUsername.text.toString()
            val password = binding.edPassword.text.toString()
            if(username == "kiwi" && password == "123456"){
                //save data to preferences
                val pref = requireContext().getSharedPreferences("user", Context.MODE_PRIVATE)
                pref.edit()
                    .putString("USER", password)
                    .putInt("LEVEL", 3)
                    .apply()
                findNavController().navigate(R.id.action_LoginFragment_to_SignUpFragment)
            }else{
                AlertDialog.Builder(requireContext())
                    .setTitle("Login")
                    .setMessage("Login Failed")
                    .setPositiveButton("OK",null)
                    .show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}