package com.example.testtask.gamesScreen.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testtask.R
import com.example.testtask.databinding.ActivityGamesBinding
import com.example.testtask.gamesScreen.presentation.GamesViewModel
import com.example.testtask.gamesScreen.ui.recycler.IRecyclerItemCallback
import com.example.testtask.gamesScreen.ui.recycler.RecyclerAdapter
import com.example.testtask.streamsScreen.ui.StreamsActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class GamesActivity : AppCompatActivity(), IRecyclerItemCallback {
	private val binding by lazy { ActivityGamesBinding.inflate(layoutInflater) }
	private val vm by viewModel<GamesViewModel>()
	private val adapter = RecyclerAdapter(this)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)

		binding.recyclerView.adapter = adapter

		vm.getGames()

		vm.games.observe(this) {
			adapter.submitList(it.data)
		}
	}

	override fun onRecyclerItemClick(gameId: String) {
		val sharedPrefs = getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE)
		sharedPrefs.edit().putString("KEY", gameId).apply()

		val intent = Intent(this, StreamsActivity::class.java)
		startActivity(intent)
	}
}