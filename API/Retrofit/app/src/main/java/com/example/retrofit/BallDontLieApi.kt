package com.example.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BallDontLieApi {
    @GET("players/{id}")
     suspend fun getPlayer(@Path("id") id: Int): Response<Player>
}