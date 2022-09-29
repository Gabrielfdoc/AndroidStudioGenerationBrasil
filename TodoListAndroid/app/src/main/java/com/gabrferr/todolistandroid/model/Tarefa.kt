package com.gabrferr.todolistandroid.model

class Tarefa(
	var id: Long,
	var nome: String,
	var descricao: String,
	var responsavel: String,
	var data: String,
	var status: Boolean,
	var categoria: Categoria
) {

}