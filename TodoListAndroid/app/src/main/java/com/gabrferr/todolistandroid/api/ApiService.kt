package com.gabrferr.todolistandroid.api

import com.gabrferr.todolistandroid.model.Categoria
import com.gabrferr.todolistandroid.model.Tarefa
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

	@GET("categoria")
	suspend fun listCategoria(): Response<List<Categoria>>

	@GET("tarefa")
	suspend fun listTarefa(): Response<List<Tarefa>>

	@POST("tarefa")
	suspend fun addTarefa(
		@Body tarefa: Tarefa
	): Response<Tarefa>
}