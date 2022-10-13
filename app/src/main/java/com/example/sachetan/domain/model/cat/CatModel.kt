package com.example.sachetan.domain.model.cat

import com.google.gson.annotations.SerializedName

data class CatModel(
    @SerializedName("fact")
    val fact: String,

    @SerializedName("length")
    val length: Int
)