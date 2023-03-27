package com.example.myapplication

import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

// button 1 For example: Calling for backup!
// second to issue a Warn the townspeople.

//The  Saloon button should have a background image,
// set the title alignment to center,
// set the font size to 20,
// and also add a drop shadow.
// You also want to set corner radius of 10, a border width of 2, a border color of blue,
// set the background color to red and also set the button's alpha to 0.5 to make it look more professional.

//Button yellow, and when released, changes back to its original color.
// Also, set the tint color of the button's image to purple to make it stand out.

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        saloonBtn()
        yellowBtn()
        sheriffBtn()
        blacksmithBtn()
        shakeBtn()
    }



    // Sheriff Button
    private fun sheriffBtn(){
        val sheriffBtn = findViewById<Button>(R.id.buttonSheriff)
        val options1 = listOf("Call for backup!", "Warn the townspeople")
        sheriffBtn.setOnClickListener {
            val popup = PopupMenu(this,sheriffBtn)
            options1.forEach { option ->
                popup.menu.add(option)
            }
            popup.setOnMenuItemClickListener { item ->
                when (item.title) {
                    "Call for backup!" -> Toast.makeText(this,"Called for backup!",Toast.LENGTH_SHORT).show()
                    "Warn the townspeople" -> Toast.makeText(this,"Warned the townspeople",Toast.LENGTH_SHORT).show()
                    else -> { /* do nothing */ }
                }
                true
            }
            popup.show()
        }
    }

// Saloon Button
    private fun saloonBtn(){
        val saloonBtn = findViewById<Button>(R.id.buttonSaloon)
        val options2 = listOf("Chicken Wings with Beer", "Beef Wellington")
        saloonBtn.setOnClickListener {
            val popup = PopupMenu(this,saloonBtn)
            options2.forEach { option ->
                popup.menu.add(option)
            }
            popup.setOnMenuItemClickListener { item ->
                when (item.title) {
                    "Chicken Wings with Beer" -> Toast.makeText(this,"Chickens getting ready..",Toast.LENGTH_SHORT).show()
                    "Beef Wellington" -> Toast.makeText(this,"Wellington is on the way..",Toast.LENGTH_SHORT).show()
                    else -> { /* do nothing */ }
                }
                true
            }
            popup.show()
        }
    }

    private fun yellowBtn(){
        val yellowBtn=findViewById<Button>(R.id.buttonYellow)
        yellowBtn.setOnTouchListener{ v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> v.setBackgroundColor(Color.parseColor("#FFFF00"))
                MotionEvent.ACTION_UP -> v.setBackgroundColor(Color.parseColor("#A020F0"))
            }
            false
        }
    }

    // Saloon Button
    private fun blacksmithBtn(){
        val buttonBlacksmith = findViewById<Button>(R.id.buttonBlacksmith)
        val buttonInvisible = findViewById<Button>(R.id.buttonInvisible)

        buttonBlacksmith.setOnClickListener {
            buttonInvisible.visibility=View.VISIBLE

        }
    }

    private fun shakeBtn(){
        val buttonShake = findViewById<Button>(R.id.buttonShake)
        val mediaPlayer = MediaPlayer.create(this, R.raw.vibration)
        buttonShake.setOnClickListener {
            val shake = AnimationUtils.loadAnimation(this, R.anim.shake)
            buttonShake.startAnimation(shake)
        }
    }







}



