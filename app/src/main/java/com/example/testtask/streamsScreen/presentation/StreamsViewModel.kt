package com.example.testtask.streamsScreen.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask.streamsScreen.data.StreamsListModel
import com.example.testtask.streamsScreen.domain.GetStreamsUseCase
import kotlinx.coroutines.launch

class StreamsViewModel(
	private val useCase: GetStreamsUseCase
): ViewModel() {
	private val _streams = MutableLiveData<StreamsListModel>()
	val streams: LiveData<StreamsListModel> = _streams

	fun getStreams(id: String) {
		try {
			viewModelScope.launch {
				_streams.value = useCase.execute(id)
			}
		}

		catch (e: Exception) {
			Log.e("Error", e.message!!)
		}
	}

}