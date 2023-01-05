package com.tr4n.moviedb.presentation.ui.favorite

import com.tr4n.moviedb.base.BaseViewModel
import com.tr4n.moviedb.common.utils.SingleLiveData
import com.tr4n.moviedb.domain.model.Movie
import com.tr4n.moviedb.domain.usecase.favorite.GetFavoriteMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

class FavoriteViewModel : BaseViewModel() {

    private val getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase by inject()

    val favoriteMovies = SingleLiveData<List<Movie>>()

    fun getFavoriteData() {
        executeTask(onExecute = {
            mLoading.value = true
            val movies = withContext(Dispatchers.IO) {
                getFavoriteMoviesUseCase()
            }
            favoriteMovies.postValue(movies)
            mLoading.value = false
        })
    }
}
