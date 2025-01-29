package com.prathamngundikere.rovervision.solImages.data.mappers

import com.prathamngundikere.rovervision.solImages.data.local.model.PhotosEntity
import com.prathamngundikere.rovervision.solImages.data.remote.response.PhotosDto
import com.prathamngundikere.rovervision.solImages.domain.model.Photos

fun PhotosDto.toPhotosEntity(): PhotosEntity {
    return PhotosEntity(
        earth_date = earth_date ?: "",
        id = id ?: 0,
        img_src = img_src ?: "",
        sol = sol ?: 0
    )
}

fun PhotosEntity.toPhotos(): Photos {
    return Photos(
        earth_date = earth_date,
        id = id,
        img_src = img_src,
        sol = sol
    )
}