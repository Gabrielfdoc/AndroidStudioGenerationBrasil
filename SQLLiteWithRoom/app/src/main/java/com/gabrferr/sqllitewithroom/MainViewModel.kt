package com.gabrferr.sqllitewithroom

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabrferr.sqllitewithroom.data.UserDatabase
import com.gabrferr.sqllitewithroom.data.UserRepository
import com.gabrferr.sqllitewithroom.data.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

	val selecionarUsuarios: LiveData<List<Usuario>>
	val repository: UserRepository

	init {

		val userDao = UserDatabase.getDatabase(application).userDao()
		repository = UserRepository(userDao)
		selecionarUsuarios = repository.selecionarUsuarios
	}

	fun addUsuario(usuario: Usuario) {
		viewModelScope.launch(Dispatchers.IO) {
			repository.addUsuario(usuario)
		}
	}
}