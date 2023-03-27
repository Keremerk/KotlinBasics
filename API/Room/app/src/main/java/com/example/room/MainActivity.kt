package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.room.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()

        val userDao = db.userDao()
        val scope = CoroutineScope(Dispatchers.Main)

        binding.buttonSave.setOnClickListener {
            // Create a new User object with the data entered by the user
            val user = User(
                name = binding.nameET.text.toString(),
                surname = binding.surnameET.text.toString(),
                age = binding.ageET.text.toString().toInt(),
                email = binding.emailET.text.toString(),
                // set any other fields you collected here
            )

            // Insert the User object into the database
            scope.launch {
                userDao.insert(user)
                println(user)
                Toast.makeText(this@MainActivity,"saskjdasjdakjd", Toast.LENGTH_SHORT).show()
            }
        }





    }


    private suspend fun saveUser(){

    }

}