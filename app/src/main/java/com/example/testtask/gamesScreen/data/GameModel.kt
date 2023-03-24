package com.example.testtask.gamesScreen.data

import com.squareup.moshi.Json

data class GameListModel(
	@Json(name = "data")
	val data: List<GameModel>
)

data class GameModel(
	@Json(name = "id")
	val id: String,

	@Json(name = "name")
	val name: String,

	@Json(name = "box_art_url")
	val imageUrl: String
)