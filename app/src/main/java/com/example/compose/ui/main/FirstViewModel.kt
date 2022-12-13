package com.example.compose.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.compose.data.ListRepositoryMock

class FirstViewModel: ViewModel() {
    private val repository = ListRepositoryMock
    private val _list = mutableStateOf(repository.getList())
    val list by _list

    fun addElement(e: String) {
        repository.addElement(e)
        _list.value = repository.getList()
    }

    fun remove(e: String) {
        repository.remove(e)
        _list.value = repository.getList()
    }

}