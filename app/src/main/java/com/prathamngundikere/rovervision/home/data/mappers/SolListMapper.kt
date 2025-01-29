package com.prathamngundikere.rovervision.home.data.mappers

import com.prathamngundikere.rovervision.home.data.local.model.PhotoEntity
import com.prathamngundikere.rovervision.home.data.remote.response.PhotoDto
import com.prathamngundikere.rovervision.home.domain.model.Photo

fun PhotoDto.toPhotoEntity(): PhotoEntity {
    return PhotoEntity(
        cameras = cameras ?: emptyList(),
        earth_date = earth_date ?: "",
        sol = sol ?: 0,
        total_photos = total_photos ?: 0
    )
}

fun PhotoEntity.toPhoto(): Photo {
    return Photo(
        cameras = cameras,
        earth_date = earth_date,
        sol = sol,
        total_photos = total_photos
    )
}