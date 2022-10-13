package com.example.sachetan.data.repo_impl

import com.example.sachetan.data.remote.service.CatServiceApi
import com.example.sachetan.domain.model.CatModel
import com.example.sachetan.domain.repo.CatFactsRepo
import javax.inject.Inject

class CatFactsRepoImpl @Inject constructor(
    private val catServiceApi: CatServiceApi
) : CatFactsRepo {
    override suspend fun getRandomCatFacts(): CatModel {
        return catServiceApi.getRandomCatFacts()
    }
}