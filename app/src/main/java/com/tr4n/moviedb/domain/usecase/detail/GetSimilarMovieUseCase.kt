package com.tr4n.moviedb.domain.usecase.detail

import com.tr4n.moviedb.domain.model.MovieSimilar
import com.tr4n.moviedb.domain.repository.MovieRepository
import com.tr4n.moviedb.domain.usecase.BaseUseCase
import org.koin.core.component.inject

class GetSimilarMovieUseCase : BaseUseCase<List<MovieSimilar>, GetSimilarMovieUseCase.Input>() {
    private val movieRepository: MovieRepository by inject()

    override suspend fun invoke(input: Input): List<MovieSimilar> {
        val movieId = input.id
        val page = input.page
        return movieRepository.getSimilarMovie(movieId, page)
    }

    data class Input(val id: String, val page: Int)
}
