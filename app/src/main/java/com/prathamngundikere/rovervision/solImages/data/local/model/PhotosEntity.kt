package com.prathamngundikere.rovervision.solImages.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos")
data class PhotosEntity(
    val earth_date: String,
    @PrimaryKey
    val id: Int,
    val img_src: String,
    val sol: Int
)
