package com.example.sachetan.data.remote.service.cat.di

import com.example.sachetan.data.remote.service.cat.CatServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class CatServiceApiModule {
    @Provides
    @Singleton
    fun provideCatServiceAi(
        retrofit: Retrofit
    ): CatServiceApi {
        return retrofit.create(CatServiceApi::class.java)
    }
}
