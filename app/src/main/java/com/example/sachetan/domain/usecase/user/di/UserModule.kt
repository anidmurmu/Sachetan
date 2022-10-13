package com.example.sachetan.domain.usecase.user.di

import com.example.sachetan.domain.repo.user.UserRepo
import com.example.sachetan.domain.usecase.user.GetUseInfoUseCaseImpl
import com.example.sachetan.domain.usecase.user.GetUserInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
class UserModule {

    @Provides
    @ActivityRetainedScoped
    fun provideGetUserInfoUseCase(
        userRepo: UserRepo
    ): GetUserInfoUseCase {
        return GetUseInfoUseCaseImpl(userRepo)
    }
}