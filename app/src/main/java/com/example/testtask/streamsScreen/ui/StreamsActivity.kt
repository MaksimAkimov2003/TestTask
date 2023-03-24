package com.example.testtask.streamsScreen.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.testtask.R
import com.example.testtask.databinding.ActivityGamesBinding
import com.example.testtask.databinding.ActivityStreamsBinding
import com.example.testtask.gamesScreen.presentation.GamesViewModel
import com.example.testtask.gamesScreen.ui.recycler.RecyclerAdapter
import com.example.testtask.streamsScreen.presentation.StreamsViewModel
import com.example.testtask.streamsScreen.ui.recycler.StreamsRecyclerAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class StreamsActivity : AppCompatActivity() {
	private val binding by lazy { ActivityStreamsBinding.inflate(layoutInflater) }
	private val vm by viewModel<StreamsViewModel>()
	private val adapter = StreamsRecyclerAdapter()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)

		binding.recyclerStreams.adapter = adapter

		val sharedPrefs = getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE)
		val id =  sharedPrefs.getString("KEY", null)

		vm.getStreams(id!!)

		vm.streams.observe(this) {
			adapter.submitList(it.data)
		}

	}
}