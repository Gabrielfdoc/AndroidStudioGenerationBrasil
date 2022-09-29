package com.gabrferr.viewmodelelivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.gabrferr.viewmodelelivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding
	private lateinit var mainViewModel: MainViewModel

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

		mainViewModel.contador.observe(this) {
			binding.textContador.text = it.toString()
		}

		binding.buttonClique.setOnClickListener {
			mainViewModel.adicionarNumero()
		}
	}
}