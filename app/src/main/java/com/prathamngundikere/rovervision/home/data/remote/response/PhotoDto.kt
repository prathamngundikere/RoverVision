package com.prathamngundikere.rovervision.home.data.remote.response

import com.google.gson.annotations.SerializedName

data class PhotoDto(
    @SerializedName("cameras")
    val cameras: List<String>?,
    @SerializedName("earth_date")
    val earth_date: String?,
    @SerializedName("sol")
    val sol: Int?,
    @SerializedName("total_photos")
    val total_photos: Int?
)