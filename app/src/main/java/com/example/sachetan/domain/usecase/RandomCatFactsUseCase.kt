package com.example.sachetan.domain.usecase

import com.example.sachetan.domain.model.CatModel
import com.example.sachetan.domain.repo.CatFactsRepo
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