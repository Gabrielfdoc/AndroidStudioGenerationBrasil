package com.gabrferr.todolistandroid.model

class Categoria (
	var id: Long,
	var descricao: String?,
	var tarefas: List<Tarefa>?
		) {

	override fun toString(): String {
		return descricao!!
	}
}