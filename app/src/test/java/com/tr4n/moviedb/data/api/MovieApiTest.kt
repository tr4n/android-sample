package com.tr4n.moviedb.data.api

import com.tr4n.moviedb.data.remote.MovieApi
import com.tr4n.moviedb.data.remote.response.BaseListResponse
import com.tr4n.moviedb.data.remote.response.MovieResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import org.junit.Test

class MovieApiTest : BaseApiTest() {

    private val api = getMockedApi<MovieApi>()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `getTopRatedMovies - should get response include only one movie data`() = runTest {
        val fakeJson = """
{
    "page": 1,
    "results": [
        {
            "adult": false,
            "backdrop_path": "/tmU7GeKVybMWFButWEGl2M4GeiP.jpg",
            "genre_ids": [
                18,
                80
            ],
            "id": 238,
            "original_language": "en",
            "original_title": "The Godfather",
            "overview": "Spanning the years 1945 to 1955, a chronicle of the fictional Italian-American Corleone crime family. When organized crime family patriarch, Vito Corleone barely survives an attempt on his life, his youngest son, Michael steps in to take care of the would-be killers, launching a campaign of bloody revenge.",
            "popularity": 107.656,
            "poster_path": "/3bhkrj58Vtu7enYsRolD1fZdja1.jpg",
            "release_date": "1972-03-14",
            "title": "The Godfather",
            "video": false,
            "vote_average": 8.7,
            "vote_count": 17208
        }
    ],
    "total_pages": 533,
    "total_results": 10653
}
    """.trimIndent()

        val expectedResponse = BaseListResponse(
            page = 1,
            totalPages = 533,
            totalResults = 10653,
            results = listOf(
                MovieResponse(
                    id = "238",
                    adult = false,
                    backdropPath = "/tmU7GeKVybMWFButWEGl2M4GeiP.jpg",
                    originalLanguage = "en",
                    originalTitle = "The Godfather",
                    overview = "Spanning the years 1945 to 1955, a chronicle of the fictional Italian-American Corleone crime family. When organized crime family patriarch, Vito Corleone barely survives an attempt on his life, his youngest son, Michael steps in to take care of the would-be killers, launching a campaign of bloody revenge.",
                    popularity = 107.656,
                    posterPath = "/3bhkrj58Vtu7enYsRolD1fZdja1.jpg",
                    releaseDate = "1972-03-14",
                    title = "The Godfather",
                    video = false,
                    voteAverage = 8.7,
                    voteCount = 17208,
                )
            ),
        )

        mockServer.enqueue(MockResponse().setBody(fakeJson).setResponseCode(200))
        val actualResponse = api.getTopRatedMovies(1)
        println(actualResponse.results)
        println(expectedResponse.results)

        assert(actualResponse.page == expectedResponse.page)
        assert(actualResponse.totalResults == expectedResponse.totalResults)
        assert(actualResponse.totalPages == expectedResponse.totalPages)
        assert(actualResponse.results == expectedResponse.results)
    }
}
