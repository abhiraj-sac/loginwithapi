package com.example.signinpagewithapi.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.signinpagewithapi.models.Loginresponse
import com.example.signinpagewithapi.models.Userresponse
import com.example.signinpagewithapi.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class loginviewmodel:ViewModel() {
    private lateinit var loginlivedata:LiveData<Loginresponse?>
    fun login(email:String,password:String){
        RetrofitInstance.api.userlogin(email,password)
            .enqueue(object : Callback<Loginresponse> {
                override fun onResponse(
                    call: Call<Loginresponse>,
                    response: Response<Loginresponse>
                ) {
                    Log.e("insidebody1" ,"yes")
                    if(response.body() != null){
                        val tokens: Loginresponse? = response.body()
                           loginlivedata.value = tokens
//                        Log.e("insidebody" ,"yes")
//                        Log.e("anything",response.body()?.token.toString())
                    }
                }

                override fun onFailure(call: Call<Loginresponse>, t: Throwable) {

                }

            })
    }
    fun observeloginlivedata():LiveData<Loginresponse?>{
        return loginlivedata
    }
}