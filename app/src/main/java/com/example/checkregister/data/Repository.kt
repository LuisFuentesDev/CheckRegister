package com.example.checkregister.data

import androidx.lifecycle.LiveData
import com.example.checkregister.data.local.ItemEntity
import com.example.checkregister.data.local.ItemDAO

class Repository(private val itemDao: ItemDAO) {
    suspend fun insertItem(itemEntity: ItemEntity) {
        itemDao.insertItem(itemEntity)
    }

    fun getItem(): LiveData<List<ItemEntity>>{
        return itemDao.getAllItems()
    }
}