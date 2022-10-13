package com.example.sachetan.data.remote.service.user

import com.google.gson.JsonObject
import retrofit2.http.GET
import retrofit2.http.Query

interface UserServiceApi {
    @GET("users")
    suspend fun getUserInfo(@Query("email_id")email: String): JsonObject
}