package com.tr4n.moviedb.di

import com.tr4n.moviedb.domain.usecase.detail.GetDetailMovieUseCase
import com.tr4n.moviedb.domain.usecase.detail.GetFavoriteMovieUseCase
import com.tr4n.moviedb.domain.usecase.detail.RemoveFavoriteMovieUseCase
import com.tr4n.moviedb.domain.usecase.detail.SaveFavoriteMovieUseCase
import com.tr4n.moviedb.domain.usecase.favorite.GetFavoriteMoviesUseCase
import com.tr4n.moviedb.domain.usecase.home.GetTopRatedMoviesUseCase
import org.koin.dsl.module

val useCaseModule = module {

    // Home
    single { GetTopRatedMoviesUseCase() }

    // Detail
    single { GetDetailMovieUseCase() }
    single { GetFavoriteMovieUseCase() }
    single { SaveFavoriteMovieUseCase() }
    single { RemoveFavoriteMovieUseCase() }

    // Favorite
    single { GetFavoriteMoviesUseCase() }
}
