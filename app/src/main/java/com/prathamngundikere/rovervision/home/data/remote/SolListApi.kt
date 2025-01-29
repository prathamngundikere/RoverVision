package com.prathamngundikere.rovervision.home.data.remote

import com.prathamngundikere.rovervision.BuildConfig
import com.prathamngundikere.rovervision.home.data.remote.response.SolManifestDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SolListApi {

    @GET("manifests/curiosity")
    suspend fun getSolList(
        @Query("api_key") api: String = API_KEY
    ): SolManifestDto

    companion object {
        const val API_KEY = BuildConfig.API
    }
}