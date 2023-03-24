package com.example.testtask.streamsScreen.data

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface StreamsService {
	@Headers(
		"Authorization: Bearer en059ogsm6a04tyn3vl4mfns1y3vw4",
		"Client-Id: dqa46yk7jedbmjwpk35hyj4isv3dqb",
	)
	@GET("streams")
	suspend fun getStreams(
		@Query("game_id")
		id: String
	): StreamsListModel
}