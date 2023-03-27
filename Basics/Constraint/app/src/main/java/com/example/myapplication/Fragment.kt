package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Fragment : Fragment() {
    private lateinit var binding: FragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonRef3.setOnClickListener {
            binding.buttonRef3.text = "ON"
        }

        binding.buttonSupurge3.setOnClickListener {
            binding.buttonSupurge3.text = "ON"
        }

        binding.buttonClose.setOnClickListener {
            binding.buttonRef3.text = "OFF"
            binding.buttonSupurge3.text = "OFF"
        }
    }


}