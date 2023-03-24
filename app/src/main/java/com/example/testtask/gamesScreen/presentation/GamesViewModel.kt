package com.example.testtask.gamesScreen.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask.gamesScreen.data.GameListModel
import com.example.testtask.gamesScreen.domain.GetGamesUseCase
import kotlinx.coroutines.launch

class GamesViewModel(
	private val useCase: GetGamesUseCase
) : ViewModel() {

	private val _games = MutableLiveData<GameListModel>()
	val games: LiveData<GameListModel> = _games

	fun getGames() {
		try {
			viewModelScope.launch {
				_games.value = useCase.execute()
			}
		}

		catch(e: Exception) {
			Log.e("Error", e.message!!)
		}
	}

}