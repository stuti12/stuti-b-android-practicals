package com.example.myapplication.Fragment

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val message = MutableLiveData<String>("hello")
    fun sendMessage(text: String) {
        message.value = text
    }
}