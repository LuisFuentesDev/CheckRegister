package com.example.checkregister.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.checkregister.R
import com.example.checkregister.databinding.FragmentListBinding

class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding
    private val itemsViewModel: ItemsViewModel by activityViewModels()
    val adapter = ItemAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)

        initLista()
        regresar()
        return binding.root
    }

    private fun regresar() {
        binding.buttonRegresar.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
    }

    private fun initLista() {
        itemsViewModel.getAllItems().observe(viewLifecycleOwner) {
        adapter.setData(it)
        }

        binding.recyclerView.adapter = adapter
    }

}
