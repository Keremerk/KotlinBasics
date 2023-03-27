package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.ViewTreeObserver
import android.widget.ScrollView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnTouchListener,
    ViewTreeObserver.OnScrollChangedListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        val scrollView: ScrollView = findViewById(R.id.scrollView1)

        // Invoking touch listener to detect movement of ScrollView
        scrollView.setOnTouchListener(this)
        scrollView.viewTreeObserver.addOnScrollChangedListener(this)
    }

    // We want to detect scroll and not touch,
    // so returning false in this member function
    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        return false
    }
    override fun onScrollChanged() {
        val scrollView: ScrollView = findViewById(R.id.scrollView1)
        val view = scrollView.getChildAt(scrollView.childCount - 1)
        val topDetector = scrollView.scrollY
        val bottomDetector: Int = view.bottom - (scrollView.height + scrollView.scrollY)
        if (bottomDetector == 0) {
            Toast.makeText(baseContext, "Scroll View bottom reached", Toast.LENGTH_SHORT).show()
        }
        if (topDetector <= 0) {
            Toast.makeText(baseContext, "Scroll View top reached", Toast.LENGTH_SHORT).show()
        }
    }
}