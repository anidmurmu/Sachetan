package com.example.sachetan.data.remote.service.user

import com.example.sachetan.domain.model.user.UserModel
import com.google.gson.JsonObject
import retrofit2.http.*

interface UserServiceApi {
    @GET("users")
    suspend fun getUserInfo(@Query("email_id")email: String): JsonObject?

    @POST("users")
    suspend fun saveUserInfo(@Body userModel: UserModel)
}