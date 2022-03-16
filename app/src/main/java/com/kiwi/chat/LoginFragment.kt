package com.kiwi.chat

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kiwi.chat.databinding.FraagmentLoginBinding

class LoginFragment : Fragment(){

    private var _binding: FraagmentLoginBinding? = null
    lateinit var binding: FraagmentLoginBinding

    //fragment_login
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref = requireContext().getSharedPreferences("user", Context.MODE_PRIVATE)
        val preUser = pref.getString("User", "")
        if(preUser != ""){
            binding.edUsername.setText(preUser)
        }
        binding.bLogin.setOnClickListener{
            //login
            val username = binding.edUsername.text.toString()
            val password = binding.edPassword.text.toString()
            if(username == "kiwi" && password == "123456"){
                //save data to preferences
                val prdf = requireContext().getSharedPreferences("user", Context.MODE_PRIVATE)
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