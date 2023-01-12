package com.tr4n.moviedb.presentation.ui.explore

import androidx.lifecycle.MutableLiveData
import com.tr4n.moviedb.base.BaseViewModel
import com.tr4n.moviedb.domain.model.Movie
import com.tr4n.moviedb.domain.usecase.search.SearchMovieUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

class ExploreViewModel : BaseViewModel() {
    private val searchCompaniesMovieUseCase: SearchMovieUseCase by inject()

    val listMovies = MutableLiveData<List<Movie>>()

    fun getListMovies(query: String) {
        val param = SearchMovieUseCase.Input(query)
        executeTask(onExecute = {
            mLoading.value = true
            val movies = withContext(Dispatchers.IO) {
                searchCompaniesMovieUseCase(param)
            }
            listMovies.postValue(movies)
            mLoading.value = false
        })
    }
}
