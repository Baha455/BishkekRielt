package com.example.bishkekrielt.ui.home

import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bishkekrielt.MainActivity
import com.example.bishkekrielt.data.interactors.RieltInteractor
import com.example.bishkekrielt.data.model.Data
import com.example.bishkekrielt.data.model.Sys
import com.example.bishkekrielt.data.model.WeatherData
import kotlinx.coroutines.launch
import kotlin.math.log

class HomeViewModel(private val service: RieltInteractor ) : ViewModel() {

    val data = MutableLiveData<Data>()
    val sys = MutableLiveData<Sys>()

    fun getData(){
        viewModelScope.launch {
            kotlin.runCatching {
                val rieltProject = service.loadDescription()
                if (rieltProject.isSuccessful) sys.postValue(rieltProject.body()?.sys)
            }.onFailure {
                Log.d("гэгэ", "гэгэ")
            }
        }

    }

}