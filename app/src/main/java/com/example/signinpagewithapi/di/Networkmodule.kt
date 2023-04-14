package com.example.signinpagewithapi.di

import com.example.signinpagewithapi.api.userapi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class Networkmodule {
    @Singleton
    @Provides
    fun providesretrofit():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("")
            .build()
    }
    @Singleton
    @Provides
    fun provideuserapi(retrofit: Retrofit):userapi{
        return retrofit.create(userapi::class.java)
    }

}