package com.prathamngundikere.rovervision.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.prathamngundikere.rovervision.home.data.local.SolListDao
import com.prathamngundikere.rovervision.home.data.local.model.PhotoEntity

@Database(
    entities = [PhotoEntity::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract val solListDao: SolListDao
}