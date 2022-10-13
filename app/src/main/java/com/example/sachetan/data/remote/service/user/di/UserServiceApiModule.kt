package com.example.sachetan.data.remote.service.user.di

import com.example.sachetan.data.remote.service.user.UserServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserServiceApiModule {

    @Provides
    @Singleton
    fun provideUserServiceApi(
        retrofit: Retrofit
    ): UserServiceApi {
        return retrofit.create(UserServiceApi::class.java)
    }
}