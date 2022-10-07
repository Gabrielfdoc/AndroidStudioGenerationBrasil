package com.gabrferr.sqllitewithroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gabrferr.sqllitewithroom.adapter.UserAdapter
import com.gabrferr.sqllitewithroom.databinding.FragmentListBinding

class ListFragment : Fragment() {

	private lateinit var binding: FragmentListBinding
	private lateinit var mainViewModel: MainViewModel

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		binding = FragmentListBinding.inflate(layoutInflater, container, false)

		mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

		val adapter = UserAdapter()
		binding.recyclerView.layoutManager = LinearLayoutManager(context)
		binding.recyclerView.adapter = adapter
		binding.recyclerView.setHasFixedSize(true)

		mainViewModel.selecionarUsuarios.observe(viewLifecycleOwner) {
			response -> adapter.setList(response)
		}

		binding.floatingActionButton2.setOnClickListener{
			findNavController().navigate(R.id.action_listFragment_to_addFragment)
		}

		return binding.root
	}
}