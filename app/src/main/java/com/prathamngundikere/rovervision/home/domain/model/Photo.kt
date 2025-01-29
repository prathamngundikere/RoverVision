package com.prathamngundikere.rovervision.home.domain.model

data class Photo(
    val cameras: List<String>,
    val earth_date: String,
    val sol: Int,
    val total_photos: Int
)
