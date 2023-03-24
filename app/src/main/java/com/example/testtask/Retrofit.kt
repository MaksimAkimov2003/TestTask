package com.example.testtask

import com.example.testtask.gamesScreen.data.GamesService
import com.example.testtask.streamsScreen.data.StreamsService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

fun provideLoggingInterceptor(): HttpLoggingInterceptor {
	val loggingInterceptor = HttpLoggingInterceptor()
	loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

	return loggingInterceptor
}

fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
	OkHttpClient.Builder()
		.connectTimeout(1000, TimeUnit.MILLISECONDS)
		.addInterceptor(loggingInterceptor)
		.build()

fun provideMoshi(): Moshi = Moshi.Builder()
	.add(KotlinJsonAdapterFactory())
	.build()


fun createRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit =
	Retrofit.Builder()
		.run {
			baseUrl("https://api.twitch.tv/helix/")
			client(okHttpClient)
			addConverterFactory(MoshiConverterFactory.create(moshi))
			build()
		}

fun provideGamesService(retrofit: Retrofit): GamesService = retrofit.create(GamesService::class.java)

fun provideStreamsService(retrofit: Retrofit): StreamsService = retrofit.create(StreamsService::class.java)