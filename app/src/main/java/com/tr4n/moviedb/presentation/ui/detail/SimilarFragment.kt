package com.tr4n.moviedb.presentation.ui.detail

import androidx.core.os.bundleOf
import com.bumptech.glide.Glide
import com.tr4n.moviedb.base.BaseFragment
import com.tr4n.moviedb.base.recyclerview.SimpleBDAdapter
import com.tr4n.moviedb.databinding.FragmentSimilarBinding
import com.tr4n.moviedb.databinding.ItemMovieBinding
import com.tr4n.moviedb.domain.model.Movie
import com.tr4n.moviedb.domain.model.MovieSimilar
import org.koin.androidx.viewmodel.ext.android.viewModel


class SimilarFragment :
    BaseFragment<FragmentSimilarBinding, DetailViewModel>(FragmentSimilarBinding::inflate) {

    override val viewModel: DetailViewModel by viewModel()

    private val listSimilarMovieAdapter by lazy {
        SimpleBDAdapter<ItemMovieBinding, MovieSimilar>(ItemMovieBinding::inflate) { itemBD, item, _ ->
            Glide.with(itemBD.imageMovie)
                .load(item.getFullPosterPath())
                .into(itemBD.imageMovie)
        }
    }

    override fun setupViews() {
        viewBD.recyclerSimilarMovie.adapter = listSimilarMovieAdapter
    }

    override fun initData() {
        viewModel.getSimilarMovieList(arguments?.getString(BUNDLE_MOVIE_ID).toString(), 1)
    }

    override fun observeData() {
        viewModel.similarMovieList.observe(viewLifecycleOwner) { movieList ->
            listSimilarMovieAdapter.submitList(movieList)
        }
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
