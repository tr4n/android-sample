package com.tr4n.moviedb.domain.usecase.detail

import com.tr4n.moviedb.domain.model.Movie
import com.tr4n.moviedb.domain.repository.MovieRepository
import com.tr4n.moviedb.domain.usecase.BaseUseCase
import org.koin.core.component.inject

class GetFavoriteMovieUseCase : BaseUseCase<Movie?, String>() {

    private val movieRepository: MovieRepository by inject()

    override suspend fun invoke(input: String): Movie? {
        return movieRepository.getFavoriteMovie(input)
    }
}
