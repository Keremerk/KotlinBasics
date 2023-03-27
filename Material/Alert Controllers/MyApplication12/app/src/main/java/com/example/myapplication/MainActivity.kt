package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.buttonAlert)
        val buttonMultiple = findViewById<Button>(R.id.buttonMultiple1)
        val buttonET = findViewById<Button>(R.id.buttonET)
        val buttonActionSheet = findViewById<Button>(R.id.buttonActionSheet)

        button.setOnClickListener {
            showAlert(this)
        }

        buttonMultiple.setOnClickListener {
            showAlert2(this)
        }

        buttonET.setOnClickListener {
            showAlert3(this)
        }

        buttonActionSheet.setOnClickListener {
            showActionSheet(this)

        }
    }

    // Alert with no buttons
    private fun showAlert(context: Context) {
        val builder = AlertDialog.Builder(context)
        builder.setMessage("This is an alert with no buttons.")
        builder.setCancelable(false)
        val alert = builder.create()
        alert.show()
    }

    private fun showAlert2(context: Context) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("This is a unique Alert Title")
        builder.setMessage("And this is really a unique Subtitle")

        builder.setPositiveButton("Button 1") { _, _ ->
            println("Button 1 clicked")
        }
        builder.setNegativeButton("Button 2") { _, _ ->
            println("Button 2 clicked")
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()

        val positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
        positiveButton.text = "Button 1"

        val negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE)
        negativeButton.text = "Button 2"

        positiveButton.setOnClickListener {
            Toast.makeText(this, "Button1 was clicked!", Toast.LENGTH_SHORT).show()
        }

        negativeButton.setOnClickListener {
            Toast.makeText(this, "Button2 was clicked!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showAlert3(context: Context) {
        val buttonET = findViewById<Button>(R.id.buttonET)
        buttonET.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Unique Title")
            builder.setMessage("Unique Subtitle")

            val input = EditText(this)
            builder.setView(input)

            builder.setPositiveButton("Save") { _, _ ->
                Toast.makeText(this, input.text, Toast.LENGTH_SHORT).show()
            }
            builder.show()
        }
    }



    private fun showActionSheet(context: Context) {
        val items = arrayOf("Message", "Call", "Photo","ActivityController")

        val builder = AlertDialog.Builder(context)
        builder.setTitle("Choose an option")
        builder.setItems(items) { _, which ->
            when (which) {
                0 -> {
                    Toast.makeText(context, "Message selected", Toast.LENGTH_SHORT).show()
                }
                1 -> {
                    Toast.makeText(context, "Call selected", Toast.LENGTH_SHORT).show()
                }
                2 -> {
                    Toast.makeText(context, "Photo selected", Toast.LENGTH_SHORT).show()
                }
                3 -> {
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_TITLE, "Activity Controller")
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Share files and images")
                    startActivity(Intent.createChooser(intent, "Share using"))
                }
            }
        }
        val dialog = builder.create()
        dialog.show()
    }




}
