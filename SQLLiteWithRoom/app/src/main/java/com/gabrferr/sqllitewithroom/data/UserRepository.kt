package com.gabrferr.sqllitewithroom.data

import com.gabrferr.sqllitewithroom.data.UserDao
import com.gabrferr.sqllitewithroom.data.Usuario

class UserRepository(private val userDao: UserDao) {

	val selecionarUsuarios = userDao.selecionarUsuarios()

	fun addUsuario(usuario: Usuario) {
		userDao.addUsuario(usuario)
	}
}