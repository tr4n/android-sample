package com.tr4n.moviedb.data.repository

import com.tr4n.moviedb.data.entity.MovieEntity
import com.tr4n.moviedb.data.local.AppDatabase
import com.tr4n.moviedb.data.remote.MovieApi
import com.tr4n.moviedb.data.remote.response.MovieResponse
import com.tr4n.moviedb.domain.model.Movie
import com.tr4n.moviedb.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieApi: MovieApi,
    private val database: AppDatabase,
) : MovieRepository {

    override suspend fun getDiscoverMovie(hashMap: HashMap<String, String>): List<Movie> {
        return movieApi.getDiscoverMovie(hashMap).results
            ?.map(MovieResponse::toModel)
            ?: emptyList()
    }

    override suspend fun getTopRatedMovies(page: Int): List<Movie> {
        return movieApi.getTopRatedMovies(page).results
            ?.map(MovieResponse::toModel)
            ?: emptyList()
    }

    override suspend fun getMovie(movieId: String): Movie {
        return movieApi.getMovie(movieId).toModel()
    }

    override suspend fun saveMovieFavorite(movie: Movie) {
        return database.movieDao().insert(MovieEntity(movie))
    }

    override suspend fun removeMovieFavorite(movieId: String) {
        return database.movieDao().delete(movieId)
    }

    override suspend fun getFavoriteMovie(movieId: String): Movie? {
        return kotlin.runCatching {
            database.movieDao().get(movieId).toModel()
        }.getOrNull()
    }

    override suspend fun getFavoriteMovies(): List<Movie> {
        return kotlin.runCatching {
            database.movieDao().getAll().map(MovieEntity::toModel)
        }.getOrNull() ?: emptyList()
    }

    override suspend fun querySearch(query: String): List<Movie> {
        return movieApi.getDataSearch(query).results
            ?.map(MovieResponse::toModel)
            ?: emptyList()
    }
}
