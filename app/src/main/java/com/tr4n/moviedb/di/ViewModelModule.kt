package com.tr4n.moviedb.di

import com.tr4n.moviedb.presentation.ui.detail.DetailViewModel
import com.tr4n.moviedb.presentation.ui.explore.ExploreViewModel
import com.tr4n.moviedb.presentation.ui.favorite.FavoriteViewModel
import com.tr4n.moviedb.presentation.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel() }
    viewModel { ExploreViewModel() }
    viewModel { FavoriteViewModel() }
    viewModel { DetailViewModel() }
}
