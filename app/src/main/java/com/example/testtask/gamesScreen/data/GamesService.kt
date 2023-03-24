package com.example.testtask.gamesScreen.data

import retrofit2.http.GET
import retrofit2.http.Headers

interface GamesService {
	@Headers(
		"Authorization: Bearer en059ogsm6a04tyn3vl4mfns1y3vw4",
		"Client-Id: dqa46yk7jedbmjwpk35hyj4isv3dqb",
	)
	@GET("games/top")
	suspend fun getGames(): GameListModel
}