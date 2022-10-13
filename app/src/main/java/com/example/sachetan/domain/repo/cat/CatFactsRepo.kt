package com.example.sachetan.domain.repo.cat

import com.example.sachetan.domain.model.cat.CatModel

interface CatFactsRepo {
    suspend fun getRandomCatFacts(): CatModel
}