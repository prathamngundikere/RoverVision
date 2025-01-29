package com.prathamngundikere.rovervision.home.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.prathamngundikere.rovervision.home.data.local.model.PhotoEntity

@Dao
interface SolListDao {

    @Upsert
    suspend fun insertPhotoList(photoList: List<PhotoEntity>)

    @Query("SELECT * FROM photo")
    suspend fun getPhotoList(): List<PhotoEntity>
}