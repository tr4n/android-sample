package com.tr4n.moviedb.base.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.tr4n.moviedb.common.extension.click

/**
 * Simple List Adapter
 * Bind simple data with Single View Holder type
 * @sample
 * <pre>
 * val adapter = SimpleListAdapter<Profile>(R.layout.item_profile) { itemView, profile, position ->
 *      itemView.textFirstName.text = profile.firstName
 *      itemView.textLastName.text = profile.lastName
 *      itemView.viewLineBottom.isInvisible = position == profiles.size -1 // not show bottom line if item is last
 * }
 * adapter.onItemClick = { itemView, profile, position ->
 *     // handle click item event
 * }
 * recyclerView.adapter = adapter // set adapter
 * adapter.submitList(profiles) // update data
 *
 * </pre>
 * @param itemLayoutResId : Layout resource id of item
 * @param onBind : High-order function, call when bind data into itemView
 * @param T: type of item's data
 * @author huytq
 */
open class SimpleListAdapter<T : Any>(
    @LayoutRes
    private val itemLayoutResId: Int,
    var onBind: (View, T, Int) -> Unit = { _, _, _ -> },
) : BaseListAdapter<T, BaseViewHolder<T>>() {
    var delayClick = 500
    var onItemClick: (View, T, Int) -> Unit = { _, _, _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        return object : BaseViewHolder<T>(inflateView(parent, itemLayoutResId)) {
            init {
                itemView.click(delayClick) {
                    itemData?.let {
                        onItemClick(itemView, it, absoluteAdapterPosition)
                    }
                }
            }

            override fun bindData(itemData: T) {
                super.bindData(itemData)
                onBind(itemView, itemData, absoluteAdapterPosition)
            }
        }
    }
}

open class SimpleBDAdapter<ItemBD : ViewBinding, T : Any>(
    private val onInflateItemBD: (LayoutInflater, ViewGroup?, Boolean) -> ItemBD,
    var onBind: (ItemBD, T, Int) -> Unit = { _, _, _ -> },
) : BaseListAdapter<T, BaseViewHolder<T>>() {
    var delayClick = 500
    var onItemClick: (ItemBD, T, Int) -> Unit = { _, _, _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBD = onInflateItemBD(layoutInflater, parent, false)
        return object : BaseViewHolder<T>(itemBD.root) {
            init {
                itemView.click(delayClick) {
                    itemData?.let {
                        onItemClick(itemBD, it, absoluteAdapterPosition)
                    }
                }
            }

            override fun bindData(itemData: T) {
                super.bindData(itemData)
                onBind(itemBD, itemData, absoluteAdapterPosition)
            }
        }
    }
}
