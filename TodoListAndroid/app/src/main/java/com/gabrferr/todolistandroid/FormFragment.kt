package com.gabrferr.todolistandroid

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.gabrferr.todolistandroid.databinding.FragmentFormBinding
import com.gabrferr.todolistandroid.model.Categoria
import java.lang.Exception
import java.util.*

class FormFragment : Fragment() {

	private lateinit var binding: FragmentFormBinding
	private val mainViewModel: MainViewModel by activityViewModels()

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		binding = FragmentFormBinding.inflate(layoutInflater, container, false)

		mainViewModel.listCategoria()

		mainViewModel.myCategoriaResponse.observe(viewLifecycleOwner) {
			response -> Log.d("Requisicao", response.body().toString())
			spinnerCategoria(response.body())
		}

		binding.buttonSalvar.setOnClickListener {
			findNavController().navigate(R.id.action_formFragment_to_listFragment)
		}

		return binding.root
	}

	fun spinnerCategoria(listaCategoria: List<Categoria>?) {
		if (listaCategoria.isNullOrEmpty())
			throw IllegalArgumentException("Lista vazia!")

		binding.spinnerCategoria.adapter =
			ArrayAdapter(
				requireContext(),
				androidx.transition.R.layout.support_simple_spinner_dropdown_item,
				listaCategoria
			)
	}
}

