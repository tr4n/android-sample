package com.tr4n.moviedb.domain.mapper

interface MapAbleToModel<Model> {
    fun toModel(): Model
}
