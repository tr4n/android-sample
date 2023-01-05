package com.tr4n.moviedb.di

import com.tr4n.moviedb.data.repository.MovieRepositoryImpl
import com.tr4n.moviedb.domain.repository.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<MovieRepository> {
        MovieRepositoryImpl(movieApi = get(), database = get())
    }
}
