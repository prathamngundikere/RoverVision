package com.prathamngundikere.rovervision.home.data.repository

import com.prathamngundikere.rovervision.core.database.AppDatabase
import com.prathamngundikere.rovervision.core.util.Resource
import com.prathamngundikere.rovervision.home.data.mappers.toPhoto
import com.prathamngundikere.rovervision.home.data.mappers.toPhotoEntity
import com.prathamngundikere.rovervision.home.data.remote.SolListApi
import com.prathamngundikere.rovervision.home.domain.model.Photo
import com.prathamngundikere.rovervision.home.domain.repository.SolListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SolListRepositoryImpl @Inject constructor(
    private val solListApi: SolListApi,
    private val appDatabase: AppDatabase
): SolListRepository {
    override suspend fun getSolList(): Flow<Resource<List<Photo>>> {
        return flow {
            emit(Resource.Loading(true))
            val localSolList = appDatabase.solListDao.getPhotoList()
            val shouldLoadLocalSolList = localSolList.isNotEmpty()
            if (shouldLoadLocalSolList) {
                emit(Resource.Success(
                    data = localSolList.map {
                        it.toPhoto()
                    }
                ))
                emit(Resource.Loading(false))
                return@flow
            }
            val solListFromApi = try {
                solListApi.getSolList().photo_manifest.photos
            } catch (e: Exception) {
                emit(Resource.Error("Error while loading"))
                return@flow
            }
            val solListEntity = solListFromApi.let {
                it.map {
                    it.toPhotoEntity()
                }
            }
            appDatabase.solListDao.insertPhotoList(solListEntity)
            emit(Resource.Success(
                solListEntity.map {
                    it.toPhoto()
                }
            ))
            emit(Resource.Loading(false))
        }
    }
}