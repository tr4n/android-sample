package com.tr4n.moviedb.presentation.ui.favorite

import androidx.lifecycle.viewModelScope
import com.tr4n.moviedb.base.BaseViewModel
import com.tr4n.moviedb.domain.model.Movie
import com.tr4n.moviedb.domain.usecase.favorite.GetFavoriteMoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.core.component.inject

class FavoriteViewModel : BaseViewModel() {

    private val getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase by inject()

    val favoriteMovies = MutableStateFlow((listOf<Movie>()))

    init {
        getFavoriteMoviesUseCase.invoke().onEach { data ->
            favoriteMovies.value = data
        }.launchIn(viewModelScope)
    }
}
