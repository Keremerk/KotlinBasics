package com.example.myapplication

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import com.example.myapplication.databinding.ActivityMainBinding
import java.lang.Math.sqrt
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Period
import java.util.*



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonCheck = findViewById<View>(R.id.buttonCheck)
        val buttonCheck_prime = findViewById<View>(R.id.buttonCheck_prime)
        var editTextHello = findViewById<EditText>(R.id.text_palindrome)
        var text_prime = findViewById<EditText>(R.id.text_prime)


        //When pressed on palindrome button
        buttonCheck.setOnClickListener {
            val text = editTextHello.text.toString()
            if (ispalindrome(text)) {
                Toast.makeText(this, "Entered word is palindrome ", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "Entered word is not a Palindrome", Toast.LENGTH_SHORT).show()
            }
        }
        //When pressed on Prime button
        buttonCheck_prime.setOnClickListener {
            if (text_prime.text.isNotEmpty()) {
                if (text_prime.text.isDigitsOnly()) {
                    val num = text_prime.text.toString().toInt()
                    if (CheckPrime(num)) {
                        Toast.makeText(
                            this,
                            "Entered number is a Prime Number.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            this,
                            "Entered number is a not a Prime Number.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        this,
                        "please enter a valid number.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    this,
                    "please enter a number",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

    //Palindrome Checker Function
    private fun ispalindrome(text: String): Boolean {
        val reverseString = text.reversed().toString()
        return text.equals(reverseString, ignoreCase = true)
    }

    //Prime Checker Function
    private fun CheckPrime(num: Int): Boolean {
        // Corner case
        if (num <= 1) return false

        // Check from 2 to square root of n
        for (i in 2..sqrt(num.toDouble()).toInt()) if (num % i == 0) return false
        return true
    }

    fun Boolean.reversed(): Boolean {
        return !this
    }



    @RequiresApi(Build.VERSION_CODES.O)
    private fun Date.calculateTwoDates(aDate: String) {
        val sdf= SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = sdf.format(this.time)

        val period = Period.between(LocalDate.parse(date), LocalDate.parse(aDate))
        val numberOfDays = period.days

        println(numberOfDays)

    }



    fun TextView.setSize() {
        binding.textPalindrome.setOnClickListener {
            this.setTextSize(5,15.5f)
        }

    }

    fun ImageView.setBackground() {
        binding.imageView.setOnClickListener {
            this.setImageResource(R.drawable.ic_launcher_background)
        }

    }

    private fun Button.setButtonBackColor() {

        binding.buttonCheck.setOnClickListener {
            val color = Color.rgb(85, 155, 0)
            this.setBackgroundColor(color)
        }

    }

    }





