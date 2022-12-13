package com.example.compose.ui.second


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.compose.data.ListRepositoryMock

class SecondViewModel : ViewModel() {
    private val repository = ListRepositoryMock
    private val _number = mutableStateOf(repository.getList().size)
    val number by _number
}