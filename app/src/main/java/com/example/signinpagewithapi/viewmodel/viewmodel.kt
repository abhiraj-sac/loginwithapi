package com.example.signinpagewithapi.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.signinpagewithapi.models.Userresponse
import com.example.signinpagewithapi.repo.repository

class viewmodel():ViewModel() {
    var posts = MutableLiveData<Userresponse?>()

    val repository =repository()
    init {
        Log.e("tags", "viewmodel called")
        repository.apicall()
       posts =  repository.getresponse()
//        posts.value = repository.posts.value
        Log.e("resultdata", posts.value.toString())
    }
    fun getresponse(): MutableLiveData<Userresponse?> {

      return posts
    }
}