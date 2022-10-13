package com.example.sachetan.domain.usecase.user

import com.example.sachetan.domain.model.user.UserModel
import com.example.sachetan.domain.repo.user.UserRepo
import javax.inject.Inject

interface GetUserInfoUseCase {
    suspend fun getUserInfo(emailId: String): UserModel
}

class GetUseInfoUseCaseImpl @Inject constructor(
    private val userRepo: UserRepo
): GetUserInfoUseCase {
    override suspend fun getUserInfo(emailId: String): UserModel {
        return userRepo.getUserInfo(emailId)
    }
}