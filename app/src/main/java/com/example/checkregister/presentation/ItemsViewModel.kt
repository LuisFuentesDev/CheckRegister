package com.example.checkregister.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.checkregister.data.Repository
import com.example.checkregister.data.local.ItemEntity
import com.example.checkregister.data.local.ItemDataBase
import kotlinx.coroutines.launch

class ItemsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository

    init {
        val dao = ItemDataBase.getDatabase(application).getItemsDao()
        repository = Repository(dao)
    }

    fun getAllItems(): LiveData<List<ItemEntity>> = repository.getItem()

    fun insertItem(nombre: String, precio: Int, cantidad: Int) = viewModelScope.launch {
        val itemEntity = ItemEntity(nombre, precio, cantidad)
        repository.insertItem(itemEntity)
    }
}