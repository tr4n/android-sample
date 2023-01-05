package com.tr4n.moviedb.domain.repository

import com.tr4n.moviedb.domain.model.Movie

interface MovieRepository {

    suspend fun getDiscoverMovie(hashMap: HashMap<String, String> = HashMap()): List<Movie>

    suspend fun getTopRatedMovies(page: Int): List<Movie>

    suspend fun getMovie(movieId: String): Movie

    suspend fun saveMovieFavorite(movie: Movie)

    suspend fun removeMovieFavorite(movieId: String)

    suspend fun getFavoriteMovie(movieId: String): Movie?

    suspend fun getFavoriteMovies(): List<Movie>
}
