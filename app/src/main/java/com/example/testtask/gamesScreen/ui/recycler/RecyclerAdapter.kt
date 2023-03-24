package com.example.testtask.gamesScreen.ui.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.testtask.gamesScreen.data.GameListModel
import com.example.testtask.gamesScreen.data.GameModel

class RecyclerAdapter(private val listener: IRecyclerItemCallback) :
	ListAdapter<GameModel, RecyclerViewHolder>(DiffCallback) {

	override fun onCreateViewHolder(
		parent: ViewGroup,
		viewType: Int
	): RecyclerViewHolder =
		RecyclerViewHolder.from(parent)

	override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
		holder.bind(game = getItem(position), listener = listener)
	}
}

object DiffCallback : DiffUtil.ItemCallback<GameModel>() {

	override fun areItemsTheSame(
		oldItem: GameModel,
		newItem: GameModel
	): Boolean = oldItem == newItem

	override fun areContentsTheSame(
		oldItem: GameModel,
		newItem: GameModel
	): Boolean = oldItem.id == newItem.id

}