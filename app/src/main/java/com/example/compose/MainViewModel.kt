package com.example.compose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _list = mutableStateOf(listOf("Todo 1", "Todo 2", "Todo 3", "Todo 4", "Todo 5"))
    val list by _list

    fun addElement(e : String){
        _list.value += e
    }

    fun remove (e : String){
        _list.value -= e
    }

}