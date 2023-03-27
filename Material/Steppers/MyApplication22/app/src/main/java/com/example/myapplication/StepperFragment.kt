package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentStepperBinding


class StepperFragment : Fragment() {
    private lateinit var binding: FragmentStepperBinding
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStepperBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            countTV.text = count.toString()

            incrementButton.setOnClickListener {
                if (count < 50) {
                    count += 5
                    countTV.text = count.toString()
                }
            }

            decrementButton.setOnClickListener {
                if (count > 0) {
                    count -= 5
                    countTV.text = count.toString()
                }
            }
        }
    }
}