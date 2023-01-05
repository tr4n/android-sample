package com.tr4n.moviedb.domain.usecase.detail

import com.tr4n.moviedb.domain.model.Movie
import com.tr4n.moviedb.domain.repository.MovieRepository
import com.tr4n.moviedb.domain.usecase.BaseUseCase
import org.koin.core.component.inject

class GetDetailMovieUseCase : BaseUseCase<Movie, GetDetailMovieUseCase.Input>() {

    private val movieRepository: MovieRepository by inject()

    override suspend fun invoke(input: Input): Movie {
        return movieRepository.getMovie(input.id)
    }

    data class Input(val id: String)
}
