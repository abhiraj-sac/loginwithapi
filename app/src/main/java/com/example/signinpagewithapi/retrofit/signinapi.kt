package com.example.signinpagewithapi.retrofit

import com.example.signinpagewithapi.models.Userresponse
import retrofit2.Call
import retrofit2.http.GET

interface signinapi {

    @GET("/users")
    fun getsignin():Call<Userresponse>
}