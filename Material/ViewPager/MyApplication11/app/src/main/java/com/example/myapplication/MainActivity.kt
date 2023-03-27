package com.example.myapplication

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titles = listOf(
            "THIS IS MOON",
            "This is a random picture",
            "You better like LOTR"
        )

        val images = listOf(
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3
        )

        val subtitles = listOf(
            "Swipe right",
            "Swipe left or right",
            "Need this mug"
        )


        val adapter = ViewPagerAdapter(images,subtitles, titles)
        binding.viewPager.adapter = adapter

    }
}