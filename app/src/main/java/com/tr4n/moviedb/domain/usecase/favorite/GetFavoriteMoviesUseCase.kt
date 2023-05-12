package com.tr4n.moviedb.domain.usecase.favorite

import com.tr4n.moviedb.domain.model.Movie
import com.tr4n.moviedb.domain.repository.MovieRepository
import com.tr4n.moviedb.domain.usecase.NoParamUseCase
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetFavoriteMoviesUseCase : KoinComponent {

    private val movieRepository: MovieRepository by inject()

    fun invoke(): Flow<List<Movie>> {
        return movieRepository.getFavoriteMovies()
    }
}
