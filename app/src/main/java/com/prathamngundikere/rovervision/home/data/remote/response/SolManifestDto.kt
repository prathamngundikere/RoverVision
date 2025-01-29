package com.prathamngundikere.rovervision.home.data.remote.response

import com.google.gson.annotations.SerializedName

data class SolManifestDto(
    @SerializedName("photo_manifest")
    val photo_manifest: PhotoManifestDto
)