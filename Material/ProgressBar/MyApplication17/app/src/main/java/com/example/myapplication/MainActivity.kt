package com.example.myapplication
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.DrawableCompat
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private val externalScope: CoroutineScope = GlobalScope
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)

        progressBar.max = 100

        button.setOnClickListener {
            val progress = (progressBar.progress + 10) % 100
            progressBar.progress = progress

            externalScope.launch(Dispatchers.Main) {
                for (progress in 0..100) {
                    delay(100)
                    progressBar.progress = progress
                    textView.text = progress.toString() + "/" + progressBar.max
                    val colorStateList = ColorStateList.valueOf(Color.RED)
                    progressBar.progressBackgroundTintList = colorStateList
                    if (progress % 10 == 0) {
                        val drawable = DrawableCompat.wrap(progressBar.progressDrawable)
                                when (progress) {
                                    0 -> DrawableCompat.setTint(drawable, Color.RED)
                                    10 -> DrawableCompat.setTint(drawable, Color.YELLOW)
                                    20 -> DrawableCompat.setTint(drawable, Color.BLUE)
                                    30 -> DrawableCompat.setTint(drawable, Color.MAGENTA)
                                    40 -> DrawableCompat.setTint(drawable, Color.CYAN)
                                    50 -> DrawableCompat.setTint(drawable, Color.GREEN)
                                    60 -> DrawableCompat.setTint(drawable, Color.RED)
                                    70 -> DrawableCompat.setTint(drawable, Color.YELLOW)
                                    80 -> DrawableCompat.setTint(drawable, Color.BLUE)
                                    90 -> DrawableCompat.setTint(drawable, Color.MAGENTA)
                                    else -> Color.BLACK
                                }
                        if (progress == 100) {
                            textView.text = "0"
                            progressBar.visibility = View.INVISIBLE
                            button.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }
    }
}
