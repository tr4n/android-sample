package com.tr4n.moviedb.domain.model

import android.os.Parcelable
import com.tr4n.moviedb.BuildConfig
import kotlinx.parcelize.Parcelize


@Parcelize
data class MovieSimilar(
    var adult: Boolean? = null,
    var backdropPath: String? = null,
    var genreIds: ArrayList<Int> = arrayListOf(),
    var id: Int? = null,
    var originalLanguage: String? = null,
    var originalTitle: String? = null,
    var overview: String? = null,
    var popularity: Double? = null,
    var posterPath: String? = null,
    var releaseDate: String? = null,
    var title: String? = null,
    var video: Boolean? = null,
    var voteAverage: Double? = null,
    var voteCount: Int? = null
) : Parcelable {
    fun getFullPosterPath() =
        (BuildConfig.SMALL_IMAGE_URL + posterPath).takeIf { posterPath.isNullOrBlank().not() }
}
