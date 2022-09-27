package com.gabrferr.todolistandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gabrferr.todolistandroid.adapter.TarefaAdapter
import com.gabrferr.todolistandroid.databinding.FragmentListBinding
import com.gabrferr.todolistandroid.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

	private lateinit var binding: FragmentListBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		binding = FragmentListBinding.inflate(layoutInflater, container, false)

		val listTarefas = listOf(
			Tarefa(
				"Passear com o cachorro",
				"Passear com o cachorro a noite, meia hora",
				"Gabriel",
				"2022-27-09",
				false,
				"Dia a dia"
			), Tarefa(
				"Fazer a comida da semana",
				"Fazer a comida da semana toda",
				"Gabriel",
				"2022-26-09",
				true,
				"Semanal"
			), Tarefa(
				"Limpar a casa",
				"Limpar a casa inteira",
				"Gabriel",
				"2022-27-09",
				false,
				"Dia a dia"
			)
		)

		//configuração do RecyclerView
		val adapter = TarefaAdapter()
		binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
		binding.recyclerTarefa.adapter = adapter
		binding.recyclerTarefa.setHasFixedSize(true)

		adapter.setList(listTarefas)

		binding.floatingAdd.setOnClickListener {
			findNavController().navigate(R.id.action_listFragment_to_formFragment)
		}

		return binding.root
	}
}