package com.example.testtask.gamesScreen.domain

import com.example.testtask.gamesScreen.data.GameListModel
import com.example.testtask.gamesScreen.data.GamesService

class GetGamesUseCase(private val api: GamesService) {
	suspend fun execute(): GameListModel {
		return api.getGames()
	}
}