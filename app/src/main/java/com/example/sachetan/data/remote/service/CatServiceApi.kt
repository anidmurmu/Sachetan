package com.example.sachetan.data.remote.service

import com.example.sachetan.domain.model.CatModel
import retrofit2.http.GET

interface CatServiceApi {
        @GET("fact/")
        suspend fun getRandomCatFacts(): CatModel
}