package com.example.signinpagewithapi.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.signinpagewithapi.models.Userresponse
import com.example.signinpagewithapi.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class repository( private var retrofit: RetrofitInstance = RetrofitInstance) {

     var result: MutableLiveData<Userresponse?> = MutableLiveData()

     init {
         apicall()
          Log.e("tags", "intitfuncalled")
     }
    fun apicall(){
        Log.e("tags", "apicall start")
         retrofit.api.getsignin().enqueue(object : Callback<Userresponse?>{
              override fun onResponse(call: Call<Userresponse?>, response: Response<Userresponse?>) {
                  Log.e("tags", "waitforresponse")
                   if(response.isSuccessful){
                       Log.e("result", "onrepnsuccesssful")
//                        result = response.body().toString()
                        if(response.body() != null){
                             Log.e("tags" , response.body().toString())

                        }
                   }
                  else{
                      Log.e("tags", response.errorBody().toString())
                   }
              }

              override fun onFailure(call: Call<Userresponse?>, t: Throwable) {
                   t.message?.let { Log.e("onfailed" , it) }
              }

         })
    }
}
