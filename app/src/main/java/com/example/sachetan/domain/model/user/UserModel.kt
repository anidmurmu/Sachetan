package com.example.sachetan.domain.model.user

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("name")
    val name: String,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("phone_num")
    val phoneNum: String,

    @SerializedName("email_id")
    val emailId: String,

    @SerializedName("age")
    val age: String,

    @SerializedName("emergency_name")
    val emergencyName: String,

    @SerializedName("emergency_phone_num")
    val emergencyPhoneNum: String,

    @SerializedName("is_professional")
    val isProfessional: Boolean = false
)