package com.prathamngundikere.rovervision.solImages.domain.repository

import com.prathamngundikere.rovervision.core.util.Resource
import com.prathamngundikere.rovervision.solImages.domain.model.Photos
import kotlinx.coroutines.flow.Flow

interface SolPhotosRepository {
    suspend fun getSolPhotoList(sol: Int): Flow<Resource<List<Photos>>>
}