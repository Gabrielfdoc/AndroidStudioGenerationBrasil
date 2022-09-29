package com.gabrferr.todolistandroid.api

import com.gabrferr.todolistandroid.model.Categoria
import retrofit2.Response

class Repository {

	suspend fun listCategoria(): Response<List<Categoria>> {
		return RetrofitInstance.api.listCategoria()
	}
}