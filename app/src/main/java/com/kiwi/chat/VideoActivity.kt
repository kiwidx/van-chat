package com.kiwi.chat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kiwi.chat.databinding.ActivityVideoBinding

class VideoActivity : AppCompatActivity() {
    lateinit var binding:ActivityVideoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityVideoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bPicture.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            val dest = Intent.createChooser(intent,"Select")
            startActivityForResult(dest,0)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val uri = data?.data
        val iv = binding.ivPic
        iv.setImageURI(uri)
    }
}