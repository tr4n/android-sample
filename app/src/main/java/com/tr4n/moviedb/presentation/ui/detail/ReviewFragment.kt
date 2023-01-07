package com.tr4n.moviedb.presentation.ui.detail

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.tr4n.moviedb.R
import com.tr4n.moviedb.base.BaseFragment
import com.tr4n.moviedb.databinding.FragmentReviewBinding
import com.tr4n.moviedb.domain.model.Movie

class ReviewFragment :
    BaseFragment<FragmentReviewBinding, DetailViewModel>(FragmentReviewBinding::inflate) {

    override val viewModel: DetailViewModel by viewModels()

    override fun setupViews() {
        viewBD.tvVoteAverage.text =
            getString(
                R.string.average_rating,
                arguments?.getDouble(BUNDLE_MOVIE_AVERAGE).toString()
            )
        viewBD.tvVoteCount.text =
            getString(R.string.number_of_reviews, arguments?.getInt(BUNDLE_MOVIE_COUNT).toString())
    }

    override fun initData() {
    }

    companion object {
        private const val BUNDLE_MOVIE_AVERAGE = "BUNDLE_MOVIE_AVERAGE"
        private const val BUNDLE_MOVIE_COUNT = "BUNDLE_MOVIE_COUNT"
        fun newInstance(movieDetail: Movie) = ReviewFragment().apply {
            arguments = bundleOf(
                BUNDLE_MOVIE_AVERAGE to movieDetail.voteAverage,
                BUNDLE_MOVIE_COUNT to movieDetail.voteCount
            )
        }
    }
}
