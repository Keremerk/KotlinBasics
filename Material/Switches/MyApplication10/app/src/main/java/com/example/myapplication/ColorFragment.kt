package com.example.myapplication

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentColorBinding

class ColorFragment : Fragment() {
    private lateinit var binding: FragmentColorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentColorBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            switchOnOff.thumbTintList = ColorStateList.valueOf(Color.BLACK)
            switchOnOff.setOnClickListener {
                if (switchOnOff.isChecked)
                {
                    this@ColorFragment.view?.setBackgroundColor(Color.GREEN)
                    switchOnOff.thumbTintList=ColorStateList.valueOf(Color.RED)
                }
                else
                {
                    this@ColorFragment.view?.setBackgroundColor(Color.RED)
                    switchOnOff.thumbTintList=ColorStateList.valueOf(Color.GREEN)
                }

            }

        }
    }



}