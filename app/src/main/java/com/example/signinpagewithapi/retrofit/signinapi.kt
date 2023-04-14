package com.example.signinpagewithapi.retrofit

import com.example.signinpagewithapi.models.Userresponse
import retrofit2.Call
import retrofit2.http.GET

interface signinapi {
//    https://reqres.in/api/users?page=2
    @GET("/api/users?page=2")
    fun getsignin():Call<Userresponse>
}