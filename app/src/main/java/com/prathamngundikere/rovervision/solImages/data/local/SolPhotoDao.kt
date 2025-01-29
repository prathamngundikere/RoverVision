package com.prathamngundikere.rovervision.solImages.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.prathamngundikere.rovervision.solImages.data.local.model.PhotosEntity

@Dao
interface SolPhotoDao {

    @Upsert
    suspend fun insertPhotosList(photosList: List<PhotosEntity>)

    @Query("SELECT * FROM photos WHERE sol = :sol")
    suspend fun getPhotosList(sol: Int): List<PhotosEntity>
}