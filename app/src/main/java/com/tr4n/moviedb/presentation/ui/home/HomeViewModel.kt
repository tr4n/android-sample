package com.tr4n.moviedb.presentation.ui.home

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.tr4n.moviedb.base.BaseViewModel
import com.tr4n.moviedb.base.paging.BasePagingSource
import com.tr4n.moviedb.domain.usecase.home.GetTopRatedMoviesUseCase
import org.koin.core.component.inject

class HomeViewModel : BaseViewModel() {
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase by inject()

    val topRatedMoviesFlow by lazy {
        Pager(PagingConfig(20)) {
            BasePagingSource { page ->
                getTopRatedMoviesUseCase(GetTopRatedMoviesUseCase.Input(page))
            }
        }.flow.cachedIn(scope)
    }
}
