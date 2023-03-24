package com.example.testtask.gamesScreen.ui.recycler

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testtask.databinding.GamesItemBinding
import com.example.testtask.gamesScreen.data.GameModel

class RecyclerViewHolder(
	private val binding: GamesItemBinding
) : RecyclerView.ViewHolder(binding.root) {

	companion object {

		fun from(parent: ViewGroup): RecyclerViewHolder {
			val inflater = LayoutInflater.from(parent.context)
			val binding = GamesItemBinding.inflate(inflater, parent, false)
			return RecyclerViewHolder(binding)
		}
	}

	fun bind(game: GameModel, listener: IRecyclerItemCallback) {
		val url = game.imageUrl.replace(oldValue = "{width}x{height}", newValue = "200x200")

		Glide.with(binding.root.context)
			.load(url)
			.into(binding.gameImage)

		binding.gameTitle.text = game.name
		binding.gameItem.setOnClickListener { listener.onRecyclerItemClick(game.id) }

	}
}