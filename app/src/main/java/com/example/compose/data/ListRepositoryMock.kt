package com.example.compose.data

object ListRepositoryMock {
    private var _list = arrayListOf("Todo 1", "Todo 2", "Todo 3", "Todo 4", "Todo 5")

    fun getList (): List<String> = _list.toList()

    fun addElement(e : String){
        _list.add(e)
    }

    fun remove (e : String){
        _list.remove(e)
    }
}