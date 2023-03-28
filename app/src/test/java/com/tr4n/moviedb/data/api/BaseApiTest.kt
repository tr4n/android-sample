package com.tr4n.moviedb.data.api

import com.tr4n.moviedb.data.remote.ServiceGenerator
import okhttp3.Interceptor
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Base class to make Api calls
 */
abstract class BaseApiTest {

    protected val mockServer = MockWebServer()

    init {
        mockServer.start()
    }

    protected fun getMockedRestApiBuilder(interceptors: List<Interceptor>): Retrofit {
        val client = ServiceGenerator.buildOkHttpClient(interceptors)
        return Retrofit.Builder()
            .baseUrl(mockServer.url("/").toString())
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    protected inline fun <reified T> getMockedApi(interceptors: List<Interceptor> = emptyList()): T =
        getMockedRestApiBuilder(interceptors).create(T::class.java)

    @After
    fun tearDown() {
        mockServer.shutdown()
    }
}
