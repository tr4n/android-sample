package com.tr4n.moviedb.data.api

import com.tr4n.moviedb.data.remote.MovieApi
import com.tr4n.moviedb.data.remote.middleware.ApiKeyInterceptor
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import org.junit.Test

class ApiKeyInterceptorTest : BaseApiTest() {

    private val api = getMockedApi<MovieApi>(listOf(ApiKeyInterceptor("secret_key")))

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `should add apikey parameter if it does not exist`() = runTest {

        mockServer.enqueue(MockResponse().setBody("{}").setResponseCode(200))
        api.getMovie("238")
        val paramApiKey = mockServer.takeRequest().requestUrl?.queryParameter("api_key")
        assert(paramApiKey == "secret_key")
    }
}
