package com.tr4n.moviedb.presentation.ui.detail

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class DetailAdapter(fragment: Fragment, private var totalCount: Int) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return totalCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OverviewFragment()
            1 -> GenresFragment()
            2 -> ReviewFragment()
            else -> OverviewFragment()
        }
    }
}
