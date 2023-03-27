package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Math.sqrt


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonCheck = findViewById<View>(R.id.buttonCheck)
        var editTextHello = findViewById<EditText>(R.id.text_palindrome)

        buttonCheck.setOnClickListener {
            val text = editTextHello.text.toString()
            if (ispalindrome(text)) {
                Toast.makeText(this, "Entered word is palindrome ", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "Entered word is not a Palindrome", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun ispalindrome(text: String): Boolean {
        val reverseString = text.reversed().toString()
        return text.equals(reverseString, ignoreCase = true)
    }







}
