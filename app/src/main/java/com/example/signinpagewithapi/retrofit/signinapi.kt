package com.example.signinpagewithapi.retrofit

import com.example.signinpagewithapi.models.Loginresponse
import com.example.signinpagewithapi.models.Userresponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface signinapi {
//    https://reqres.in/api/users?page=2
    @GET("/api/users?page=2")
    fun getsignin():Call<Userresponse>
    @FormUrlEncoded
    @POST("login")
    fun userlogin(
        @Field("email")email:String,
       @Field("password")password:String
    ):Call<Loginresponse>
}