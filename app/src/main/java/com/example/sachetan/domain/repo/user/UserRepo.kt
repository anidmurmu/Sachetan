package com.example.sachetan.domain.repo.user

import com.example.sachetan.domain.model.user.UserModel

interface UserRepo {
    suspend fun getUserInfo(emailId: String): UserModel
    //suspend fun saveUserInfo(userModel: UserModel)
}