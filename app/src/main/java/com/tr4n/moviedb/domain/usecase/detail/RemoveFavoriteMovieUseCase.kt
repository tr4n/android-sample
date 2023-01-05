package com.tr4n.moviedb.domain.usecase.detail

import com.tr4n.moviedb.domain.repository.MovieRepository
import com.tr4n.moviedb.domain.usecase.BaseUseCase
import org.koin.core.component.inject

class RemoveFavoriteMovieUseCase : BaseUseCase<Unit, String>() {

    private val movieRepository: MovieRepository by inject()

    override suspend fun invoke(input: String) {
        return movieRepository.removeMovieFavorite(input)
    }
}
