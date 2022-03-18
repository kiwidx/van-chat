package com.kiwi.chat

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kiwi.chat.databinding.FragmentRoomBinding

class RoomFragment : Fragment() {

    private lateinit var binding: FragmentRoomBinding
    val TAG = RoomFragment::class.java.simpleName
    val messages = mutableListOf<String>("呼呼","嘿","哈哈哈哈哈","呼呼","嘿","哈哈哈哈哈","呼呼","嘿","哈哈哈哈哈")
    var map = mutableMapOf<Int,String>(0 to "Sun", 1 to "Mon")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRoomBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val room = arguments?.getParcelable<Lightyear>("room")
        Log.d(TAG, "room: ${room?.stream_title}");
//        https://player.vimeo.com/video/653928650
        binding.videoView.setVideoURI((Uri.parse("https://player.vimeo.com/video/653928650")))
    }

}