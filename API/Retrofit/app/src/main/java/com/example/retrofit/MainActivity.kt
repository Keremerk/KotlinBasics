package com.example.retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var ballDontLieApi : BallDontLieApi? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val coroutineScope = CoroutineScope(Dispatchers.Main)


        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.balldontlie.io/api/v1/")
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        ballDontLieApi = retrofit.create(BallDontLieApi::class.java)

        coroutineScope.launch {
            ballDontLieApi?.let {
                getListPlayer().collectLatest {
                    if (it.isSuccessful){
                        println(it.body())
                    }
                }
            }
        }
    }

    private fun getListPlayer() : Flow<Response<Player>> {
        return flow {
          val response =  ballDontLieApi!!.getPlayer(237)
            emit(response)
        }
    }
}




