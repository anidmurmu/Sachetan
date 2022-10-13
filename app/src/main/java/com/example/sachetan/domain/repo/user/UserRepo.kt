package com.example.sachetan.domain.repo.user

import com.example.sachetan.domain.model.user.UserModel
import com.google.gson.JsonObject

interface UserRepo {
    suspend fun getUserInfo(emailId: String): UserModel
    suspend fun saveUserInfo(userModel: UserModel)
}