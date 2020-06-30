package com.baseproject.model

import com.google.gson.annotations.SerializedName

data class APIResponse<T> constructor(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("message") val error: String?,
    @SerializedName("data")
    val data: T?,
    @SerializedName("accessToken")
    val accessToken: String?
)