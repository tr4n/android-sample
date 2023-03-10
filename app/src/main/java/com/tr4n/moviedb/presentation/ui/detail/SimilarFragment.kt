package com.tr4n.moviedb.presentation.ui.detail

import androidx.core.os.bundleOf
import com.tr4n.moviedb.base.BaseFragment
import com.tr4n.moviedb.databinding.FragmentSimilarBinding
import com.tr4n.moviedb.domain.model.Movie
import org.koin.androidx.viewmodel.ext.android.viewModel


class SimilarFragment :
    BaseFragment<FragmentSimilarBinding, DetailViewModel>(FragmentSimilarBinding::inflate) {

    override val viewModel: DetailViewModel by viewModel()

    override fun setupViews() {
    }

    override fun initData() {
    }

    override fun observeData() {
        super.observeData()
    }

    companion object {
        private const val BUNDLE_MOVIE_ID = "BUNDLE_MOVIE_ID"
        fun newInstance(movieDetail: Movie) = SimilarFragment().apply {
            arguments = bundleOf(
                BUNDLE_MOVIE_ID to movieDetail.id,
            )
        }
    }
}
