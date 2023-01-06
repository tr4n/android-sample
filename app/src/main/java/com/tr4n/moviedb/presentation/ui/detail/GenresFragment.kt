package com.tr4n.moviedb.presentation.ui.detail

import androidx.core.os.bundleOf
import com.tr4n.moviedb.base.BaseFragment
import com.tr4n.moviedb.databinding.FragmentGenresBinding
import com.tr4n.moviedb.domain.model.Movie
import org.koin.androidx.viewmodel.ext.android.viewModel

class GenresFragment
    : BaseFragment<FragmentGenresBinding, DetailViewModel>(FragmentGenresBinding::inflate) {

    companion object {
        private const val BUNDLE_MOVIE = "BUNDLE_MOVIE"
        fun newInstance(movieDetail: Movie) = GenresFragment().apply {
            arguments = bundleOf(BUNDLE_MOVIE to movieDetail)
        }
    }

    override val viewModel: DetailViewModel by viewModel()

    override fun setupViews() {

    }

    override fun initData() {
    }

    override fun observeData() {
        super.observeData()
    }


}
