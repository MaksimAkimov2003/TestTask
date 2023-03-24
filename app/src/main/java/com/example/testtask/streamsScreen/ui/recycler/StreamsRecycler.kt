package com.example.testtask.streamsScreen.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testtask.databinding.StreamsItemBinding
import com.example.testtask.streamsScreen.data.StreamModel

class StreamsRecyclerAdapter :
	ListAdapter<StreamModel, RecyclerStreamsViewHolder>(DiffCallback) {

	override fun onCreateViewHolder(
		parent: ViewGroup,
		viewType: Int
	): RecyclerStreamsViewHolder =
		RecyclerStreamsViewHolder.from(parent)

	override fun onBindViewHolder(holder: RecyclerStreamsViewHolder, position: Int) {
		holder.bind(stream = getItem(position))
	}
}

object DiffCallback : DiffUtil.ItemCallback<StreamModel>() {

	override fun areItemsTheSame(
		oldItem: StreamModel,
		newItem: StreamModel
	): Boolean = oldItem == newItem

	override fun areContentsTheSame(
		oldItem: StreamModel,
		newItem: StreamModel
	): Boolean = oldItem.title == newItem.title

}

class RecyclerStreamsViewHolder(
	private val binding: StreamsItemBinding
) : RecyclerView.ViewHolder(binding.root) {

	companion object {

		fun from(parent: ViewGroup): RecyclerStreamsViewHolder {
			val inflater = LayoutInflater.from(parent.context)
			val binding = StreamsItemBinding.inflate(inflater, parent, false)
			return RecyclerStreamsViewHolder(binding)
		}
	}

	fun bind(stream: StreamModel) {
		val url = stream.url.replace(oldValue = "{width}x{height}", newValue = "200x200")

		Glide.with(binding.root.context)
			.load(url)
			.into(binding.streamImage)

		binding.streamTitle.text = stream.title
	}
}