package com.example.checkregister.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.checkregister.data.Repository
import com.example.checkregister.data.local.Item
import com.example.checkregister.data.local.ItemDataBase
import kotlinx.coroutines.launch

class ItemsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository

    init {
        val dao = ItemDataBase.getDatabase(application).getItemsDao()
        repository = Repository(dao)
    }

    fun getAllItems(): LiveData<List<Item>> = repository.getItem()

    fun insertItem(nombre: String, precio: Int, cantidad: Int) = viewModelScope.launch {
        val item = Item(nombre, precio, cantidad)
        repository.insertItem(item)
    }
}