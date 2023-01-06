package com.tr4n.moviedb.presentation.ui.detail

import androidx.fragment.app.viewModels
import com.tr4n.moviedb.base.BaseFragment
import com.tr4n.moviedb.databinding.FragmentReviewBinding

class ReviewFragment :
    BaseFragment<FragmentReviewBinding, DetailViewModel>(FragmentReviewBinding::inflate) {
    override val viewModel: DetailViewModel by viewModels()

    override fun setupViews() {

    }

    override fun initData() {
    }

    override fun observeData() {
        super.observeData()
    }
}
