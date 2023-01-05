package com.tr4n.moviedb.presentation.ui.detail

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tr4n.moviedb.R
import com.tr4n.moviedb.base.BaseFragment
import com.tr4n.moviedb.common.extension.click
import com.tr4n.moviedb.common.extension.load
import com.tr4n.moviedb.databinding.FragmentDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment :
    BaseFragment<FragmentDetailBinding, DetailViewModel>(FragmentDetailBinding::inflate) {

    override val viewModel: DetailViewModel by viewModel()

    private val args by navArgs<DetailFragmentArgs>()

    override fun setupViews() {
        viewBD.buttonFavorite.click {
            viewModel.markFavoriteOrNot()
        }
        viewBD.buttonBack.click {
            findNavController().popBackStack()
        }
    }

    override fun initData() {
        viewModel.getMovieInformation(args.movieId)
    }

    //observeData
    override fun observeData() {
        viewModel.detailMovie.observe(viewLifecycleOwner) { movie ->
            viewBD.imageBackdrop.load(movie.getFullBackdropPath())
            viewBD.imageMoviePoster.load(movie.getFullPosterPath())
            viewBD.textMovieName.text = movie.title
            viewBD.textOverview.text = movie.overview
            viewBD.textDateRelease.text = movie.releaseDate
            viewBD.textRuntime.text = getString(R.string.minutes, movie.runtime.toString())
            viewBD.textVoteAverage.text = movie.voteAverage.toString()
        }
        viewModel.favorite.observe(viewLifecycleOwner) { isFavorite ->
            val res =
                if (isFavorite) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24
            viewBD.buttonFavorite.setImageResource(res)
        }
    }
}
