package com.example.sachetan.domain.usecase.cat

import com.example.sachetan.domain.model.cat.CatModel
import com.example.sachetan.domain.repo.cat.CatFactsRepo
import javax.inject.Inject

interface GetRandomCatFactsUseCase {
    suspend fun getRandomCatFacts(): CatModel
}

class GetRandomCatFactsUseCaseImpl @Inject constructor(
    private val catFactsRepo: CatFactsRepo
) : GetRandomCatFactsUseCase {
    override suspend fun getRandomCatFacts(): CatModel {
        return catFactsRepo.getRandomCatFacts()
    }
}