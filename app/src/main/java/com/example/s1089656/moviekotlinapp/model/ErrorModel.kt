package com.example.s1089656.moviekotlinapp.model

import com.google.gson.annotations.SerializedName

data class ErrorModel(
        @SerializedName("status_code")
        val statusCode: Int = 0,
        @SerializedName("status_message")
        val statusMessage: String,
        @SerializedName("success")
        val success: Boolean = false
)