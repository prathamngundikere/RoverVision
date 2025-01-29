package com.prathamngundikere.rovervision.solImages.data.remote

import com.prathamngundikere.rovervision.BuildConfig
import com.prathamngundikere.rovervision.solImages.data.remote.response.SolPhotosListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SolImagesApi {

    @GET("rovers/curiosity/photos")
    suspend fun getSolImages(
        @Query("sol") sol: Int,
        @Query("api_key") api: String = BuildConfig.API
    ): SolPhotosListDto
}