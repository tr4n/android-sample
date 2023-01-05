package com.tr4n.moviedb.domain.usecase.home

import com.tr4n.moviedb.domain.model.Movie
import com.tr4n.moviedb.domain.repository.MovieRepository
import com.tr4n.moviedb.domain.usecase.BaseUseCase
import org.koin.core.component.inject

class GetTopRatedMoviesUseCase : BaseUseCase<List<Movie>, GetTopRatedMoviesUseCase.Input>() {

    private val movieRepository: MovieRepository by inject()

    override suspend fun invoke(input: Input): List<Movie> {
        val page = input.page
        return movieRepository.getTopRatedMovies(page)
    }

    data class Input(val page: Int)
}
