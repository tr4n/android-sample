package com.tr4n.moviedb.presentation.ui.detail

import androidx.core.os.bundleOf
import com.bumptech.glide.Glide
import com.tr4n.moviedb.base.BaseFragment
import com.tr4n.moviedb.base.recyclerview.SimpleBDAdapter
import com.tr4n.moviedb.databinding.FragmentCastBinding
import com.tr4n.moviedb.databinding.ItemCastBinding
import com.tr4n.moviedb.domain.model.Cast
import com.tr4n.moviedb.domain.model.Movie
import org.koin.androidx.viewmodel.ext.android.viewModel

class CastFragment
    : BaseFragment<FragmentCastBinding, DetailViewModel>(FragmentCastBinding::inflate) {


    override val viewModel: DetailViewModel by viewModel()

    private val listCastMovieAdapter by lazy {
        SimpleBDAdapter<ItemCastBinding, Cast>(ItemCastBinding::inflate) { itemBD, item, _ ->
            Glide.with(itemBD.imageMovie)
                .load(item.getFullProfilePath())
                .into(itemBD.imageMovie)
            itemBD.tvRealName.text = item.name
        }
    }

    override fun setupViews() {
        viewBD.rcvCast.adapter = listCastMovieAdapter
    }

    override fun initData() {
        viewModel.getCastInformation(arguments?.getString(BUNDLE_MOVIE_ID).toString())
    }

    override fun observeData() {
        viewModel.castMovie.observe(viewLifecycleOwner) { cast ->
            listCastMovieAdapter.submitList(cast)
        }
    }

    companion object {
        private const val BUNDLE_MOVIE_ID = "BUNDLE_MOVIE_ID"
        fun newInstance(movieDetail: Movie) = CastFragment().apply {
            arguments = bundleOf(BUNDLE_MOVIE_ID to movieDetail.id)
        }
    }
}
