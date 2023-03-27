package com.example.myapplication

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentLottieBinding

class LottieFragment : Fragment() {
    private lateinit var binding: FragmentLottieBinding
    private var animationState = false
    private var animationStart = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLottieBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.imageView.setImageDrawable(null)
        binding.buttonSharpen.isVisible=false
        binding.buttonStartStop.isVisible=false

        binding.startanimationView.addAnimatorListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
               // binding.animationView.isVisible=true
                binding.buttonSharpen.isVisible=true
                binding.animationView.visibility = View.VISIBLE
                binding.startanimationView.setImageResource(R.drawable.ww2)
            }
        })
        binding.buttonSharpen.setOnClickListener {
            binding.buttonStartStop.isVisible=true
        }

        binding.buttonStartStop.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this.context, R.anim.fade_out)
            if (!animationStart){

                binding.animationView.startAnimation(animation)
                animationStart = true
                animationState = true

            }else{
                if (!animationState) {
                    binding.animationView.resumeAnimation()
                    animationState = true
                }
                else{
                    binding.animationView.pauseAnimation()
                    animationState = false
                }
            }
        }


        return view
    }

    /*
     if (clicks == 1) {
                // Do something on first click
                if (animationPaused) {
                    binding.animationView.resumeAnimation()
                } else {
                    binding.animationView.playAnimation()
                    Handler().postDelayed({
                        binding.animationView.visibility = View.GONE
                    }, 1000)
                }
                animationPaused = false

            } else if (clicks == 2) {
                // Do something on second click
                binding.animationView.pauseAnimation()
                animationPaused = true
                clicks = 0 // Reset clicks for next time
            }
     */

/*
  binding.buttonStartStop.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this.context, R.anim.fade_out)
            if (!animationStart){
                binding.animationView.visibility = View.VISIBLE
                binding.animationView.startAnimation(animation)
                animationStart = true
                animationState = true
            }else{
                if (!animationState){
                    binding.animationView.resumeAnimation()
                    animationState = true
                }else{
                    binding.animationView.pauseAnimation()
                    animationState = false
                }
            }

        }
 */


}