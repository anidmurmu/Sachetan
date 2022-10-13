package com.example.sachetan.data.repo_impl.user

import com.example.sachetan.data.remote.service.user.UserServiceApi
import com.example.sachetan.domain.model.user.UserModel
import com.example.sachetan.domain.repo.user.UserRepo
import com.google.gson.Gson
import com.google.gson.JsonObject
import javax.inject.Inject

class UserRepoImpl @Inject constructor(
    private val gson: Gson,
    private val userServiceApi: UserServiceApi
) : UserRepo {
    override suspend fun getUserInfo(emailId: String): UserModel {
        val resp = userServiceApi.getUserInfo(emailId)
        val ans = "do somthing"
        val parsedResp = gson.fromJson(
            resp,
            UserModel::class.java
        )
        return parsedResp
    }

    override suspend fun saveUserInfo(userModel: UserModel) {
        userServiceApi.saveUserInfo(userModel)
    }
}