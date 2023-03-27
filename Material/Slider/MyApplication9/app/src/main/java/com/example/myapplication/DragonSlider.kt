package com.example.myapplication

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentDragonSliderBinding
import com.google.android.material.slider.Slider

class DragonSlider : Fragment() {
    private lateinit var binding: FragmentDragonSliderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDragonSliderBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            slider3.apply {
                stepSize = 1F
                valueFrom = 0F
                valueTo = 50F
                thumbTintList = ColorStateList.valueOf(Color.BLUE)
                trackActiveTintList = ColorStateList.valueOf(Color.GREEN)
                trackInactiveTintList = ColorStateList.valueOf(Color.RED)
            }
        }
    }
}