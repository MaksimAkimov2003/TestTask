package com.example.testtask.streamsScreen.domain

import android.util.Log
import com.example.testtask.streamsScreen.data.StreamsListModel
import com.example.testtask.streamsScreen.data.StreamsService

class GetStreamsUseCase(private val api: StreamsService) {
	suspend fun execute(id: String): StreamsListModel {
		return api.getStreams(id)
	}
}