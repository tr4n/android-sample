package com.tr4n.moviedb.domain.usecase.favorite

import com.tr4n.moviedb.domain.model.Movie
import com.tr4n.moviedb.domain.repository.MovieRepository
import com.tr4n.moviedb.domain.usecase.NoParamUseCase
import org.koin.core.component.inject

class GetFavoriteMoviesUseCase : NoParamUseCase<List<Movie>>() {

    private val movieRepository: MovieRepository by inject()

    override suspend fun invoke(): List<Movie> {
        return movieRepository.getFavoriteMovies()
    }
}
