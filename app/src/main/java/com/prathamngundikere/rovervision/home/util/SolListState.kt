package com.prathamngundikere.rovervision.home.util

import com.prathamngundikere.rovervision.home.domain.model.Photo

data class SolListState(
    val isLoading: Boolean = false,
    val photoList: List<Photo> = emptyList()
)
