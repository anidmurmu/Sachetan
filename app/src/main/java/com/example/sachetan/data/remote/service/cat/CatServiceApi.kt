package com.example.sachetan.data.remote.service.cat

import com.example.sachetan.domain.model.cat.CatModel
import retrofit2.http.GET

interface CatServiceApi {
        @GET("fact/")
        suspend fun getRandomCatFacts(): CatModel
}