package com.example.sachetan.domain.usecase.user

import com.example.sachetan.domain.model.user.UserModel
import com.example.sachetan.domain.repo.user.UserRepo
import com.google.gson.JsonObject
import javax.inject.Inject

interface SaveUserInfoUseCase {
    suspend fun saveUserInfo(userModel: UserModel)
}

class SaveUserInfoUseCaseImpl @Inject constructor(
    private val userRepo: UserRepo
) : SaveUserInfoUseCase {
    override suspend fun saveUserInfo(userModel: UserModel) {
        userRepo.saveUserInfo(userModel)
    }
}