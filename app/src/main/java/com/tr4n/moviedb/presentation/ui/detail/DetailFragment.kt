package com.tr4n.moviedb.presentation.ui.detail

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.tr4n.moviedb.R
import com.tr4n.moviedb.base.BaseFragment
import com.tr4n.moviedb.common.extension.click
import com.tr4n.moviedb.common.extension.load
import com.tr4n.moviedb.databinding.FragmentDetailBinding
import com.tr4n.moviedb.domain.model.Movie
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment :
    BaseFragment<FragmentDetailBinding, DetailViewModel>(FragmentDetailBinding::inflate) {

    override val viewModel: DetailViewModel by viewModel()

    private val args by navArgs<DetailFragmentArgs>()

    private var tabTitle = listOf(
        R.string.overview,
        R.string.review,
        R.string.cast,
        R.string.similar
    )

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

    override fun observeData() {
        viewModel.detailMovie.observe(viewLifecycleOwner) { movie ->
            viewBD.imageBackdrop.load(movie.getFullBackdropPath())
            viewBD.imageMoviePoster.load(movie.getFullPosterPath())
            viewBD.textMovieName.text = movie.title
            viewBD.textDateRelease.text = movie.releaseDate
            viewBD.textRuntime.text = getString(R.string.minutes, movie.runtime.toString())
            viewBD.textHasAdultContent.text =
                if (movie.adult == true) getString(R.string.yes) else getString(R.string.no)
            setUpViewPager(movie)
            setUpTabLayout()
        }
        viewModel.favorite.observe(viewLifecycleOwner) { isFavorite ->
            val res =
                if (isFavorite) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24
            viewBD.buttonFavorite.setImageResource(res)
        }
    }

    private fun setUpTabLayout() {
        TabLayoutMediator(viewBD.tabLayoutDetail, viewBD.viewPagerDetail) { tab, position ->
            tab.text = getString(tabTitle[position])
        }.attach()
    }

    private fun setUpViewPager(movieDetail: Movie) {
        val adapter =
            DetailAdapter(
                this,
                listOf(
                    OverviewFragment.newInstance(movieDetail = movieDetail),
                    ReviewFragment.newInstance(movieDetail = movieDetail),
                    CastFragment.newInstance(movieDetail = movieDetail),
                    SimilarFragment.newInstance(movieDetail = movieDetail)
                )
            )
        viewBD.viewPagerDetail.adapter = adapter
    }

}
