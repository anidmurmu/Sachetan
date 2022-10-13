package com.example.sachetan.data.repo_impl.cat

import com.example.sachetan.data.remote.service.cat.CatServiceApi
import com.example.sachetan.domain.model.cat.CatModel
import com.example.sachetan.domain.repo.cat.CatFactsRepo
import javax.inject.Inject

class CatFactsRepoImpl @Inject constructor(
    private val catServiceApi: CatServiceApi
) : CatFactsRepo {
    override suspend fun getRandomCatFacts(): CatModel {
        return catServiceApi.getRandomCatFacts()
    }
}