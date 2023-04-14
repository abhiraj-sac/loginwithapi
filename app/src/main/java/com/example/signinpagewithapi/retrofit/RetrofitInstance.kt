package com.example.signinpagewithapi.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api:signinapi by lazy {
        Retrofit.Builder()
//        Response{protocol=h2, code=404, message=, url=https://reqres.in/users?page=2}
        .baseUrl("https://reqres.in/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(signinapi::class.java)
    }
}