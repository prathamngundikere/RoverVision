package com.prathamngundikere.rovervision.core.di

import android.app.Application
import androidx.room.Room
import com.prathamngundikere.rovervision.core.database.AppDatabase
import com.prathamngundikere.rovervision.home.data.remote.SolListApi
import com.prathamngundikere.rovervision.home.data.repository.SolListRepositoryImpl
import com.prathamngundikere.rovervision.home.domain.repository.SolListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Singleton
    @Provides
    fun provideSolListApi(): SolListApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.nasa.gov/mars-photos/api/v1/")
            .client(client)
            .build()
            .create(SolListApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            context = app,
            klass = AppDatabase::class.java,
            name = "rover.db"
        ).build()
    }

    @Provides
    fun provideSolListRepo(
        solListApi: SolListApi,
        appDatabase: AppDatabase
    ): SolListRepository {
        return SolListRepositoryImpl(solListApi, appDatabase)
    }
}