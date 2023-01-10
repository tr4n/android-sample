package com.tr4n.moviedb.domain.usecase.detail

import com.tr4n.moviedb.domain.model.MovieReview
import com.tr4n.moviedb.domain.repository.MovieRepository
import com.tr4n.moviedb.domain.usecase.BaseUseCase
import org.koin.core.component.inject

class GetReviewMovieUseCase : BaseUseCase<List<MovieReview>, GetReviewMovieUseCase.Input>() {
    private val movieRepository: MovieRepository by inject()

    override suspend fun invoke(input: Input): List<MovieReview> {
        val movieId = input.id
        val page = input.page
        return movieRepository.getReviewMovie(movieId, page)
    }

    data class Input(val id: String, val page: Int)
}
