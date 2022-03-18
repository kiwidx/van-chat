package com.kiwi.chat

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import com.kiwi.chat.databinding.FragmentSignBinding

class SignFragment : Fragment() {

    private var _binding: FragmentSignBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val TAG = SignFragment::class.java.simpleName

    var signup_state = false

    val selectPictureFromGallery =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
                binding.iPic.setImageURI(it)
                uri.toString()//content://ccc.ddd/sss/aaa
            }
        }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentSignBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
                Log.d(TAG, "SignUp: success")
            }else{
                AlertDialog.Builder(requireContext())
                    .setTitle("Wrong Message")
                    .setMessage(errormeg)
                    .setPositiveButton("Ok", null)
                    .show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}