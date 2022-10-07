package com.gabrferr.sqllitewithroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gabrferr.sqllitewithroom.data.Usuario
import com.gabrferr.sqllitewithroom.databinding.FragmentAddBinding

class AddFragment : Fragment() {

	private lateinit var binding: FragmentAddBinding
	private lateinit var mainViewModel: MainViewModel

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		binding = FragmentAddBinding.inflate(layoutInflater, container, false)

		mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

		binding.buttonAdicionar.setOnClickListener {
			inserirNoBanco()
		}

		return binding.root
	}

	fun verificarCampos(nome: String, sobrenome: String, idade: String): Boolean {
		return (nome.isNotBlank() && sobrenome.isNotBlank() && idade.isNotBlank())
	}

	fun inserirNoBanco() {
		val nome = binding.editTextNome.text.toString()
		val sobrenome = binding.editTextSobrenome.text.toString()
		val idade = binding.editTextIdade.text.toString()

		if (verificarCampos(nome, sobrenome, idade)) {
			val usuario = Usuario(0, nome, sobrenome, idade.toInt())
			mainViewModel.addUsuario(usuario)
			Toast.makeText(context, "Usuário adicionado!", Toast.LENGTH_LONG).show()
			findNavController().navigate(R.id.action_addFragment_to_listFragment)
		} else {
			Toast.makeText(context, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
		}
	}
}