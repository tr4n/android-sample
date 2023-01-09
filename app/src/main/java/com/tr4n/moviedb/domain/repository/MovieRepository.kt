package com.tr4n.moviedb.domain.repository

import com.tr4n.moviedb.domain.model.Cast
import com.tr4n.moviedb.domain.model.Movie
import com.tr4n.moviedb.domain.model.MovieSimilar

interface MovieRepository {

    suspend fun getDiscoverMovie(hashMap: HashMap<String, String> = HashMap()): List<Movie>

    suspend fun getTopRatedMovies(page: Int): List<Movie>

    suspend fun getMovie(movieId: String): Movie

    suspend fun saveMovieFavorite(movie: Movie)

    suspend fun removeMovieFavorite(movieId: String)

    suspend fun getFavoriteMovie(movieId: String): Movie?

    suspend fun getFavoriteMovies(): List<Movie>

    suspend fun getMovieCast(movieId: String): List<Cast>

    suspend fun getSimilarMovie(movieId: String, page: Int): List<MovieSimilar>
}
