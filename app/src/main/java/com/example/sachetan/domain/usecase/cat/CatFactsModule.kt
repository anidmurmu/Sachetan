package com.example.sachetan.domain.usecase.cat

import com.example.sachetan.domain.repo.cat.CatFactsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
class CatFactsModule {

    @Provides
    @ActivityRetainedScoped
    fun provideGetRandomCatFactsUseCase(
        catFactsRepo: CatFactsRepo
    ): GetRandomCatFactsUseCase {
        return GetRandomCatFactsUseCaseImpl(catFactsRepo)
    }
}