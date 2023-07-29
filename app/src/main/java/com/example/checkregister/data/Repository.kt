package com.example.checkregister.data

import androidx.lifecycle.LiveData
import com.example.checkregister.data.local.Item
import com.example.checkregister.data.local.ItemDAO

class Repository(private val itemDao: ItemDAO) {
    suspend fun insertItem(item: Item) {
        itemDao.insertItem(item)
    }

    fun getItem(): LiveData<List<Item>>{
        return itemDao.getAllItems()
    }
}