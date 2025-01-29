package com.prathamngundikere.rovervision.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.prathamngundikere.rovervision.home.data.local.SolListDao
import com.prathamngundikere.rovervision.home.data.local.model.PhotoEntity
import com.prathamngundikere.rovervision.solImages.data.local.SolPhotoDao
import com.prathamngundikere.rovervision.solImages.data.local.model.PhotosEntity

@Database(
    entities = [PhotoEntity::class, PhotosEntity::class],
    version = 2
)
abstract class AppDatabase: RoomDatabase() {
    abstract val solListDao: SolListDao
    abstract val solPhotoDao: SolPhotoDao
}