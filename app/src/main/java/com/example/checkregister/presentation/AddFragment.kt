package com.example.checkregister.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.checkregister.R
import com.example.checkregister.databinding.ActivityMainBinding
import com.example.checkregister.databinding.FragmentAddBinding


class AddFragment : Fragment() {

    lateinit var binding: FragmentAddBinding
    private val itemsViewModel: ItemsViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddBinding.inflate(layoutInflater, container, false)

        initListener()

        return binding.root
    }

    private fun initListener() {
        binding.buttonGuardar.setOnClickListener{
            val nombre = binding.editTextNombre.text.toString()
            val cantidad = binding.editTextCantidad.text.toString().toInt()
            val precio = binding.editTextPrecio.text.toString().toInt()

            itemsViewModel.insertItem(nombre,cantidad,precio)

        }
    }
}