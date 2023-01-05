package com.tr4n.moviedb.data.remote

import com.tr4n.moviedb.data.remote.response.BaseListResponse
import com.tr4n.moviedb.data.remote.response.GetCastAndCrewResponse
import com.tr4n.moviedb.data.remote.response.GetMovieImagesResponse
import com.tr4n.moviedb.data.remote.response.MovieResponse
import retrofit2.http.*

interface MovieApi {

    @GET("discover/movie")
    suspend fun getDiscoverMovie(@QueryMap hashMap: HashMap<String, String> = HashMap()): BaseListResponse<MovieResponse>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query("page") page: Int = 1): BaseListResponse<MovieResponse>

    @GET("movie/{movie_id}")
    suspend fun getMovie(@Path("movie_id") movieId: String): MovieResponse

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCredits(@Path("movie_id") movieId: String): GetCastAndCrewResponse

    @GET("movie/{movie_id}/images")
    suspend fun getMovieImages(@Path("movie_id") movieId: String): GetMovieImagesResponse

}
