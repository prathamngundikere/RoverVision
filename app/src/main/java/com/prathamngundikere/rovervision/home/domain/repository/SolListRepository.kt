package com.prathamngundikere.rovervision.home.domain.repository

import com.prathamngundikere.rovervision.core.util.Resource
import com.prathamngundikere.rovervision.home.domain.model.Photo
import kotlinx.coroutines.flow.Flow

interface SolListRepository {
    suspend fun getSolList(): Flow<Resource<List<Photo>>>
}