package com.example.sachetan.data.repo_impl.cat.di

import com.example.sachetan.data.remote.service.cat.CatServiceApi
import com.example.sachetan.data.repo_impl.cat.CatFactsRepoImpl
import com.example.sachetan.domain.repo.cat.CatFactsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CatFactsRepoModule {

    @Provides
    @Singleton
    fun provideCatsRepo(
        catServiceApi: CatServiceApi
    ): CatFactsRepo {
        return CatFactsRepoImpl(catServiceApi)
    }
}