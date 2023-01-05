package com.tr4n.moviedb.presentation.ui.home

import com.tr4n.moviedb.base.BaseViewModel
import com.tr4n.moviedb.common.utils.SingleLiveData
import com.tr4n.moviedb.domain.model.Movie
import com.tr4n.moviedb.domain.usecase.home.GetTopRatedMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

class HomeViewModel : BaseViewModel() {
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase by inject()

    val topRatedMovies = SingleLiveData<List<Movie>>()

    fun getTopRatedMoviesData() {
        val param = GetTopRatedMoviesUseCase.Input(1)
        executeTask(onExecute = {
            mLoading.value = true
            val movies = withContext(Dispatchers.IO) {
                getTopRatedMoviesUseCase(param)
            }
            topRatedMovies.postValue(movies)
            mLoading.value = false
        })
    }
}
