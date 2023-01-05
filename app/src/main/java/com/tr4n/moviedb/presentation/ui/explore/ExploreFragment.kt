package com.tr4n.moviedb.presentation.ui.explore

import com.tr4n.moviedb.base.BaseFragment
import com.tr4n.moviedb.databinding.FragmentExploreBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ExploreFragment :
    BaseFragment<FragmentExploreBinding, ExploreViewModel>(FragmentExploreBinding::inflate) {

    override val viewModel: ExploreViewModel by viewModel()
}
