package com.prathamngundikere.rovervision.solImages.data.repository

import com.prathamngundikere.rovervision.core.database.AppDatabase
import com.prathamngundikere.rovervision.core.util.Resource
import com.prathamngundikere.rovervision.solImages.data.mappers.toPhotos
import com.prathamngundikere.rovervision.solImages.data.mappers.toPhotosEntity
import com.prathamngundikere.rovervision.solImages.data.remote.SolImagesApi
import com.prathamngundikere.rovervision.solImages.domain.model.Photos
import com.prathamngundikere.rovervision.solImages.domain.repository.SolPhotosRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SolPhotosRepositoryImpl @Inject constructor(
    private val solImagesApi: SolImagesApi,
    private val appDatabase: AppDatabase
): SolPhotosRepository {
    override suspend fun getSolPhotoList(sol: Int): Flow<Resource<List<Photos>>> {
        return flow {
            emit(Resource.Loading(true))
            val localSolPhotos = appDatabase.solPhotoDao.getPhotosList(sol)
            val shouldLoadLocalSolPhotoList = localSolPhotos.isNotEmpty()
            if (shouldLoadLocalSolPhotoList) {
                emit(Resource.Success(
                    data = localSolPhotos.map {
                        it.toPhotos()
                    }
                ))
                emit(Resource.Loading(false))
                return@flow
            }
            val solPhotosApi = try {
                solImagesApi.getSolImages(sol).photos
            } catch (e: Exception) {
                emit(Resource.Error("Error while loading"))
                return@flow
            }
            val solPhotosEntity = solPhotosApi.let {
                it.map {
                    it.toPhotosEntity()
                }
            }
            appDatabase.solPhotoDao.insertPhotosList(solPhotosEntity)
            emit(Resource.Success(
                solPhotosEntity.map {
                    it.toPhotos()
                }
            ))
            emit(Resource.Loading(false))
        }
    }
}