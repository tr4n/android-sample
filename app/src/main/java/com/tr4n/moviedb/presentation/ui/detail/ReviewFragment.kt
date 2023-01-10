package com.tr4n.moviedb.presentation.ui.detail

import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.tr4n.moviedb.R
import com.tr4n.moviedb.base.BaseFragment
import com.tr4n.moviedb.base.recyclerview.SimpleBDAdapter
import com.tr4n.moviedb.databinding.FragmentReviewBinding
import com.tr4n.moviedb.databinding.ItemReviewBinding
import com.tr4n.moviedb.domain.model.Movie
import com.tr4n.moviedb.domain.model.MovieReview

class ReviewFragment :
    BaseFragment<FragmentReviewBinding, DetailViewModel>(FragmentReviewBinding::inflate) {

    override val viewModel: DetailViewModel by viewModels()

    private val listReviewAdapter by lazy {
        SimpleBDAdapter<ItemReviewBinding, MovieReview>(ItemReviewBinding::inflate) { itemBD, item, _ ->
            Glide.with(itemBD.imgAvatarReview)
                .load(item.avatarPath)
                .into(itemBD.imgAvatarReview)
            itemBD.tvNameReview.text = item.author
            itemBD.tvTimeReview.text = item.createdAt
            itemBD.tvPointReview.text = item.rating.toString()
            itemBD.tvContentReview.text = item.content
        }
    }

    override fun setupViews() {
        viewBD.rcvReview.adapter = listReviewAdapter
        viewBD.tvNoReview.text =
            getString(R.string.no_review, arguments?.getString(BUNDLE_MOVIE_TITLE).toString())
    }

    override fun initData() {
        viewModel.getReviewMovieList(arguments?.getString(BUNDLE_MOVIE_ID).toString(), 1)

    }

    override fun observeData() {
        viewModel.reviewMovieList.observe(viewLifecycleOwner) { reviewList ->
            listReviewAdapter.submitList(reviewList)
            if (reviewList.isEmpty()) {
                viewBD.tvNoReview.visibility = View.VISIBLE
            }
        }
    }

    companion object {
        private const val BUNDLE_MOVIE_ID = "BUNDLE_MOVIE_ID"
        private const val BUNDLE_MOVIE_TITLE = "BUNDLE_MOVIE_TITLE"
        fun newInstance(movieDetail: Movie) = ReviewFragment().apply {
            arguments = bundleOf(
                BUNDLE_MOVIE_ID to movieDetail.id,
                BUNDLE_MOVIE_TITLE to movieDetail.title
            )
        }
    }
}
