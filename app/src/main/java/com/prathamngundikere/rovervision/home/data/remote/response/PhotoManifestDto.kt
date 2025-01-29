package com.prathamngundikere.rovervision.home.data.remote.response

import com.google.gson.annotations.SerializedName

data class PhotoManifestDto(
    @SerializedName("landing_date")
    val landing_date: String,
    @SerializedName("launch_date")
    val launch_date: String,
    @SerializedName("max_date")
    val max_date: String,
    @SerializedName("max_sol")
    val max_sol: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("photos")
    val photos: List<PhotoDto>,
    @SerializedName("status")
    val status: String,
    @SerializedName("total_photos")
    val total_photos: Int
)