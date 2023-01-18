package com.tr4n.moviedb.domain.usecase.detail

import com.tr4n.moviedb.domain.model.Cast
import com.tr4n.moviedb.domain.repository.MovieRepository
import com.tr4n.moviedb.domain.usecase.BaseUseCase
import org.koin.core.component.inject

class GetCastMovieUseCase : BaseUseCase<List<Cast>, GetCastMovieUseCase.Input>() {
    private val movieRepository: MovieRepository by inject()

    override suspend fun invoke(input: Input): List<Cast> {
        val movieId = input.id
        return movieRepository.getMovieCast(movieId)
    }

    data class Input(val id: String)
}
