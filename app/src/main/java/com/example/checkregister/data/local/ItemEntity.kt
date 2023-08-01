package com.example.checkregister.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_table")
data class ItemEntity(val nombre: String, val precio: Int, val cantidad: Int) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}