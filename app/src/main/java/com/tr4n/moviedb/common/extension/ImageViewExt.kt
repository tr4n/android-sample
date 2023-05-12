package com.tr4n.moviedb.common.extension

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.tr4n.moviedb.R

fun ImageView.setTintColor(@ColorRes colorRes: Int) {
    setColorFilter(ContextCompat.getColor(context, colorRes))
}

@SuppressLint("CheckResult")
fun ImageView.load(url: String?, placeholderRes: Drawable? = null) {
    url ?: return
    Glide.with(this)
        .load(url)
        .placeholder(placeholderRes)
        .into(this)
}
