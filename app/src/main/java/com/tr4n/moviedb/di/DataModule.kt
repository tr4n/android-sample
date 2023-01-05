package com.tr4n.moviedb.di

import com.google.gson.Gson
import com.tr4n.moviedb.BuildConfig
import com.tr4n.moviedb.data.local.AppDatabase
import com.tr4n.moviedb.data.remote.MovieApi
import com.tr4n.moviedb.data.remote.ServiceGenerator
import com.tr4n.moviedb.data.remote.middleware.ApiKeyInterceptor
import com.tr4n.moviedb.data.remote.middleware.TokenInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single {
        AppDatabase.build(androidContext())
    }

    single {
        ServiceGenerator.buildRestApi(
            baseUrl = BuildConfig.BASE_URL,
            restApi = MovieApi::class.java,
            gson = Gson(),
            interceptors = listOf(
                TokenInterceptor(),
                ApiKeyInterceptor()
            )
        )
    }
}
