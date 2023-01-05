package com.tr4n.moviedb.presentation.ui.home

import com.bumptech.glide.Glide
import com.tr4n.moviedb.R
import com.tr4n.moviedb.base.BaseFragment
import com.tr4n.moviedb.base.recyclerview.SimpleBDAdapter
import com.tr4n.moviedb.databinding.FragmentHomeBinding
import com.tr4n.moviedb.databinding.ItemMovieBinding
import com.tr4n.moviedb.domain.model.Movie
import com.tr4n.moviedb.presentation.ui.detail.DetailFragmentArgs
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment :
    BaseFragment<FragmentHomeBinding, HomeViewModel>(FragmentHomeBinding::inflate) {

    override val viewModel: HomeViewModel by viewModel()

    private val topRatedMoviesAdapter by lazy {
        SimpleBDAdapter<ItemMovieBinding, Movie>(ItemMovieBinding::inflate) { itemBD, item, _ ->
            Glide.with(itemBD.imageMovie)
                .load(item.getFullPosterPath())
                .into(itemBD.imageMovie)
        }
    }

    override fun setupViews() {
        viewBD.recyclerTopRatedMovies.adapter = topRatedMoviesAdapter.apply {
            onItemClick = { _, item, _ ->
                val bundle = DetailFragmentArgs(item.id).toBundle()
                navigate(R.id.detailFragment, bundle)
            }
        }
    }

    override fun initData() {
        viewModel.getTopRatedMoviesData()
    }

    override fun observeData() {
        viewModel.topRatedMovies.observe(viewLifecycleOwner) { movies ->
            topRatedMoviesAdapter.submitList(movies)
        }
    }
}
