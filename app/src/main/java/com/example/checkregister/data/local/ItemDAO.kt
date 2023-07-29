package com.example.checkregister.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDAO {
    @Insert
    suspend fun insertItem(item: Item)

    @Query("SELECT*FROM item_table order by id asc")

    fun getAllItems():LiveData<List<Item>>
}