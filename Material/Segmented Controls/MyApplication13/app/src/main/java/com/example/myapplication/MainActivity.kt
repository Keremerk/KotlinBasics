package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toggleGroup = findViewById<MaterialButtonToggleGroup>(R.id.toggle_group)
        val neonAcademyButton = findViewById<MaterialButton>(R.id.neon_academy_button)
        val neonButton = findViewById<MaterialButton>(R.id.neon_button)

        val appsButton = findViewById<MaterialButton>(R.id.appsButton)


        neonAcademyButton.setOnClickListener {
            val width = neonAcademyButton.width
            val height = neonAcademyButton.height
            toggleGroup.check(neonAcademyButton.id)
            neonAcademyButton.isChecked = true
            neonAcademyButton.textSize = 18f
            if(neonAcademyButton.isPressed)
                neonAcademyButton.layoutParams.width = width + 50
                neonAcademyButton.layoutParams.height = height + 50
                neonAcademyButton.requestLayout()
                neonAcademyButton.text = ""
        }

        neonButton.setOnClickListener {
            val width = neonButton.width
            val height = neonButton.height
            toggleGroup.check(neonButton.id)
            neonButton.isChecked = true
            neonButton.textSize = 16f
            if(neonButton.isPressed)
                neonButton.layoutParams.width = width - 10
                neonButton.layoutParams.height = height - 10
                neonButton.requestLayout()
        }

        appsButton.setOnClickListener {
            val widthAcademy = neonAcademyButton.width
            val heightAcademy = neonAcademyButton.height

            val widthNeon = neonButton.width
            val heightNeon = neonButton.height

            val widthToggle = appsButton.width
            val heightToggle= appsButton.height

            toggleGroup.check(appsButton.id)
            appsButton.isChecked = true
            appsButton.textSize = 18f
            if(appsButton.isPressed)
                neonAcademyButton.layoutParams.width = widthAcademy - 10
                neonAcademyButton.layoutParams.height = heightAcademy - 10

                neonButton.layoutParams.width = widthNeon - 10
                neonButton.layoutParams.height = heightNeon - 10

                appsButton.layoutParams.width = widthToggle - 10
                appsButton.layoutParams.height = heightToggle -10
            appsButton.requestLayout()
        }

    }

    }
