package com.tr4n.moviedb.domain.repository

import com.tr4n.moviedb.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getDiscoverMovie(hashMap: HashMap<String, String> = HashMap()): List<Movie>

    suspend fun getTopRatedMovies(page: Int): List<Movie>

    suspend fun getMovie(movieId: String): Movie

    suspend fun saveMovieFavorite(movie: Movie)

    suspend fun removeMovieFavorite(movieId: String)

    suspend fun getFavoriteMovie(movieId: String): Movie?

    fun getFavoriteMovies(): Flow<List<Movie>>

    suspend fun querySearch(query: String): List<Movie>
}
