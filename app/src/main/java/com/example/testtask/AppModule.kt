package com.example.testtask

import com.example.testtask.gamesScreen.domain.GetGamesUseCase
import com.example.testtask.gamesScreen.presentation.GamesViewModel
import com.example.testtask.streamsScreen.domain.GetStreamsUseCase
import com.example.testtask.streamsScreen.presentation.StreamsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
	single { provideLoggingInterceptor() }
	single { provideOkHttpClient(loggingInterceptor = get()) }
	single { provideMoshi() }
	single { createRetrofit(moshi = get(), okHttpClient = get()) }

	factory { provideGamesService(retrofit = get()) }
	factory { GetGamesUseCase(api = get()) }

	viewModel {
		GamesViewModel(
			useCase = get()
		)
	}

	factory { provideStreamsService(retrofit = get()) }
	factory { GetStreamsUseCase(api = get()) }

	viewModel {
		StreamsViewModel(
			useCase = get()
		)
	}
}