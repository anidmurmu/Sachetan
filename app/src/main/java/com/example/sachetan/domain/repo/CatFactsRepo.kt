package com.example.sachetan.domain.repo

import com.example.sachetan.domain.model.CatModel

interface CatFactsRepo {
    suspend fun getRandomCatFacts(): CatModel
}