package com.gabrferr.todolistandroid.api

import com.gabrferr.todolistandroid.model.Categoria
import com.gabrferr.todolistandroid.model.Tarefa
import retrofit2.Response

class Repository {

	suspend fun listCategoria(): Response<List<Categoria>> {
		return RetrofitInstance.api.listCategoria()
	}

	suspend fun addTarefa(tarefa: Tarefa): Response<Tarefa> {
		return RetrofitInstance.api.addTarefa(tarefa)
	}

	suspend fun listTarefa(): Response<List<Tarefa>> {
		return RetrofitInstance.api.listTarefa()
	}
}