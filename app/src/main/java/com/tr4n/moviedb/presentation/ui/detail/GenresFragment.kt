package com.tr4n.moviedb.presentation.ui.detail

import com.tr4n.moviedb.base.BaseFragment
import com.tr4n.moviedb.databinding.FragmentGenresBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GenresFragment
    : BaseFragment<FragmentGenresBinding, DetailViewModel>(FragmentGenresBinding::inflate) {
    override val viewModel: DetailViewModel by viewModel()

    override fun setupViews() {

    }

    override fun initData() {
    }

    override fun observeData() {
        super.observeData()
    }


}
