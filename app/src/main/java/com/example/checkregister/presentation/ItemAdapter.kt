package com.example.checkregister.presentation


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.checkregister.data.local.ItemEntity
import com.example.checkregister.databinding.ItemLayoutBinding

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    lateinit var binding: ItemLayoutBinding
    private val listItemEntity = mutableListOf<ItemEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = listItemEntity[position]
        holder.render(item)

    }

    override fun getItemCount(): Int {
        return listItemEntity.size
    }

    class ItemViewHolder(val v: ItemLayoutBinding) : RecyclerView.ViewHolder(v.root) {
        fun render(itemEntity: ItemEntity) {
            v.tvNombre.text = itemEntity.nombre
            v.tvCantidad.text = itemEntity.cantidad.toString()
            v.tvPrecio.text = itemEntity.precio.toString()

            v.tvTotal.text = (itemEntity.cantidad * itemEntity.precio).toString()
        }
    }
}