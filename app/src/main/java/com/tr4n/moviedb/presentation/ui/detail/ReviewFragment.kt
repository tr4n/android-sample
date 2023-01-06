package com.tr4n.moviedb.presentation.ui.detail

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.tr4n.moviedb.base.BaseFragment
import com.tr4n.moviedb.databinding.FragmentReviewBinding
import com.tr4n.moviedb.domain.model.Movie

class ReviewFragment :
    BaseFragment<FragmentReviewBinding, DetailViewModel>(FragmentReviewBinding::inflate) {

    companion object {
        private const val BUNDLE_MOVIE = "BUNDLE_MOVIE"
        fun newInstance(movieDetail: Movie) = ReviewFragment().apply {
            arguments = bundleOf(BUNDLE_MOVIE to movieDetail)
        }
    }

    override val viewModel: DetailViewModel by viewModels()

    override fun setupViews() {

    }

    override fun initData() {
    }
}
