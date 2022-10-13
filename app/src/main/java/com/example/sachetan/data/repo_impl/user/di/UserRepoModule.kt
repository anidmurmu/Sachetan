package com.example.sachetan.data.repo_impl.user.di

import com.example.sachetan.data.remote.service.user.UserServiceApi
import com.example.sachetan.data.repo_impl.user.UserRepoImpl
import com.example.sachetan.domain.repo.user.UserRepo
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserRepoModule {

    @Provides
    @Singleton
    fun provideUserRepo(
        gson: Gson,
        userServiceApi: UserServiceApi
    ): UserRepo {
        return UserRepoImpl(gson, userServiceApi)
    }
}