package com.example.signinpagewithapi.repository

import com.example.signinpagewithapi.api.userapi
import com.example.signinpagewithapi.models.Data
import javax.inject.Inject

class Userrepository
       @Inject constructor(private val userapi: userapi) {
           suspend fun registeruser(userRequest:Data){

           }
}