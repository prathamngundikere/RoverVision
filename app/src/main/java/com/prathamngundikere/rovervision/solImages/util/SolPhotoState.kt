package com.prathamngundikere.rovervision.solImages.util

import com.prathamngundikere.rovervision.solImages.domain.model.Photos

data class SolPhotoState(
    val isLoading: Boolean = false,
    val photosList: List<Photos> = emptyList()
)
