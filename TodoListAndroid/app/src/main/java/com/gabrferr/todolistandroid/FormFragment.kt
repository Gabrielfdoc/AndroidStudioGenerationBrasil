package com.gabrferr.todolistandroid

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.gabrferr.todolistandroid.databinding.FragmentFormBinding
import com.gabrferr.todolistandroid.fragment.DatePickerFragment
import com.gabrferr.todolistandroid.fragment.TimerPickerListener
import com.gabrferr.todolistandroid.model.Categoria
import com.gabrferr.todolistandroid.model.Tarefa
import java.lang.Exception
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

class FormFragment : Fragment(), TimerPickerListener {

	private lateinit var binding: FragmentFormBinding
	private val mainViewModel: MainViewModel by activityViewModels()
	private var categoriaSelecionada = 0L

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		binding = FragmentFormBinding.inflate(layoutInflater, container, false)

		mainViewModel.listCategoria()

		mainViewModel.dataSelecionada.value = LocalDate.now()

		mainViewModel.myCategoriaResponse.observe(viewLifecycleOwner) { response ->
			Log.d("Requisicao", response.body().toString())
			spinnerCategoria(response.body())
		}

		mainViewModel.dataSelecionada.observe(viewLifecycleOwner) { selectedDate ->
			binding.editData.setText(selectedDate.toString())
		}

		binding.buttonSalvar.setOnClickListener {
			inserirNoBanco()
		}

		binding.editData.setOnClickListener {
			DatePickerFragment(this)
				.show(parentFragmentManager, "DatePicker")
		}

		return binding.root
	}

	private fun spinnerCategoria(listaCategoria: List<Categoria>?) {
		if (listaCategoria.isNullOrEmpty())
			throw IllegalArgumentException("Lista vazia!")

		binding.spinnerCategoria.adapter =
			ArrayAdapter(
				requireContext(),
				androidx.transition.R.layout.support_simple_spinner_dropdown_item,
				listaCategoria
			)
		binding.spinnerCategoria.onItemSelectedListener =
			object : AdapterView.OnItemSelectedListener {
				override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
					val selected = binding.spinnerCategoria.selectedItem as Categoria

					categoriaSelecionada = selected.id
				}

				override fun onNothingSelected(p0: AdapterView<*>?) {
					TODO("Not yet implemented")
				}

			}
	}

	private fun validarCampos(nome: String, descricao: String, responsavel: String): Boolean {
		return (
				(nome.isNotBlank() || nome.length in 3..20) &&
				(descricao.isNotBlank() || descricao.length in 5..200) &&
				(responsavel.isNotBlank() || descricao.length in 3..20)
				)
	}

	private fun inserirNoBanco() {
		val nome = binding.editNome.text.toString()
		val descricao = binding.editDescricao.text.toString()
		val responsavel = binding.editResponsavel.text.toString()
		val data = binding.editData.text.toString()
		val status = binding.switchAtivoCard.isChecked
		val categoria = Categoria(categoriaSelecionada, null, null)
		val newData = LocalDateTime.now()

		if (validarCampos(nome, descricao, responsavel)) {
			val tarefa = Tarefa(0, nome, descricao, responsavel, data, status, categoria)
			mainViewModel.addTarefa(tarefa)
			Toast.makeText(context, "Tarefa criada!", Toast.LENGTH_SHORT).show()
			findNavController().navigate(R.id.action_formFragment_to_listFragment)

		} else {
			Toast.makeText(context, "Verifique os campos!", Toast.LENGTH_SHORT).show()
		}
	}

	override fun onDateSelected(date: LocalDate) {
		mainViewModel.dataSelecionada.value = date
	}
}

