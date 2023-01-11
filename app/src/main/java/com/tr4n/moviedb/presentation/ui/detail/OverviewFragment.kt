package com.tr4n.moviedb.presentation.ui.detail

import androidx.core.os.bundleOf
import com.tr4n.moviedb.base.BaseFragment
import com.tr4n.moviedb.databinding.FragmentOverviewBinding
import com.tr4n.moviedb.domain.model.Movie
import org.koin.androidx.viewmodel.ext.android.viewModel

class OverviewFragment :
    BaseFragment<FragmentOverviewBinding, DetailViewModel>(FragmentOverviewBinding::inflate) {

    override val viewModel: DetailViewModel by viewModel()

    override fun setupViews() {
        viewBD.tvOverView.text = arguments?.getString(BUNDLE_MOVIE)
    }

    override fun initData() {

    }

    companion object {
        private const val BUNDLE_MOVIE = "BUNDLE_MOVIE"
        fun newInstance(movieDetail: Movie) = OverviewFragment().apply {
            arguments = bundleOf(BUNDLE_MOVIE to movieDetail.overview)
        }
    }
}
