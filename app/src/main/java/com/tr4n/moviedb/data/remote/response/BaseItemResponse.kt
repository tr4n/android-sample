@file:Suppress("unused")
package com.tr4n.moviedb.data.remote.response

import com.google.gson.annotations.SerializedName

open class BaseItemResponse<Item>(
    @SerializedName("item")
    val item: Item? = null
)
