package com.prathamngundikere.rovervision.home.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo")
data class PhotoEntity(
    val cameras: List<String>,
    val earth_date: String,
    @PrimaryKey
    val sol: Int,
    val total_photos: Int
)
