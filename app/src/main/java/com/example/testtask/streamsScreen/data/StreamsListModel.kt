package com.example.testtask.streamsScreen.data

import com.squareup.moshi.Json

data class StreamsListModel(
	@Json(name = "data")
	val data: List<StreamModel>
)

data class StreamModel(
	@Json(name = "title")
	val title: String,

	@Json(name = "thumbnail_url")
	val url: String
)