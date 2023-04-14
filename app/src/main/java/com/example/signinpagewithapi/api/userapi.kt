package com.example.signinpagewithapi.api

import com.example.signinpagewithapi.models.Userresponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface userapi {
    @POST("/users")
    suspend fun signup(@Body userresponse: Userresponse) :Response<Userresponse>

    @POST("/login")
    suspend fun signin(@Body userresponse: Userresponse) :Response<Userresponse>
}