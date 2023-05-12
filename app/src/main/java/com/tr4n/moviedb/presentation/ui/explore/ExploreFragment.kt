package com.tr4n.moviedb.presentation.ui.explore

import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.tr4n.moviedb.R
import com.tr4n.moviedb.base.BaseFragment
import com.tr4n.moviedb.base.recyclerview.SimpleListAdapter
import com.tr4n.moviedb.common.extension.click
import com.tr4n.moviedb.common.extension.showSnackBar
import com.tr4n.moviedb.databinding.FragmentExploreBinding
import com.tr4n.moviedb.databinding.ItemMovieBinding
import com.tr4n.moviedb.domain.model.Movie
import com.tr4n.moviedb.presentation.ui.detail.DetailFragmentArgs
import org.koin.androidx.viewmodel.ext.android.viewModel

class ExploreFragment :
    BaseFragment<FragmentExploreBinding, ExploreViewModel>(FragmentExploreBinding::inflate) {

    override val viewModel: ExploreViewModel by viewModel()


    private val searchMoviesAdapter by lazy {
        SimpleListAdapter<ItemMovieBinding, Movie>(ItemMovieBinding::inflate) { item, _ ->
            Glide.with(imageMovie)
                .load(item.getFullPosterPath())
                .into(imageMovie)
        }
    }

    override fun setupViews() {
        viewBD.rcSearch.adapter = searchMoviesAdapter.apply {
            onItemClick = { item, _ ->
                val bundle = DetailFragmentArgs(item.id).toBundle()
                navigate(R.id.detailFragment, bundle)
            }
        }
    }

    override fun initData() {
        viewBD.icEmpty.isVisible = true
        viewBD.rcSearch.isVisible = true

        handleClickSearch()
    }

    private fun handleClickSearch() {
        viewBD.icSearch.click {
            val text = viewBD.etSearch.text.toString()
            if (text.length < 3){
                viewBD.root.showSnackBar(getString(R.string.input_3_characters))
                return@click
            }
            viewModel.getListMovies(text)
        }
    }

    override fun observeData() {
        viewModel.listMovies.observe(viewLifecycleOwner) { movies ->
            viewBD.icEmpty.isVisible = movies.isEmpty()
            viewBD.rcSearch.isVisible = movies.isNotEmpty()
            searchMoviesAdapter.submitList(movies)
        }
    }
}
