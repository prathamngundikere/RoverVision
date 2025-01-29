package com.prathamngundikere.rovervision.solImages.data.remote.response

import com.google.gson.annotations.SerializedName

data class SolPhotosListDto(
    @SerializedName("photos")
    val photos: List<PhotosDto>
)