package com.tr4n.moviedb.domain.usecase.search

import com.tr4n.moviedb.domain.model.Movie
import com.tr4n.moviedb.domain.repository.MovieRepository
import com.tr4n.moviedb.domain.usecase.BaseUseCase
import org.koin.core.component.inject

class SearchMovieUseCase : BaseUseCase<List<Movie>, SearchMovieUseCase.Input>() {

    private val searchRepository: MovieRepository by inject()

    override suspend fun invoke(input: Input): List<Movie> {
        val page = input.query
        return searchRepository.querySearch(page)
    }

    data class Input(val query: String)
}
