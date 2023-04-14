package com.example.signinpagewithapi.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.signinpagewithapi.repo.repository

class viewmodel():ViewModel() {
    val repository =repository()
    init {
        Log.e("tags", "viewmodel called")
        repository
    }
}