package com.andro.indie.school.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by herisulistiyanto on 10/02/19.
 * KjokenKoddinger
 */

data class ErrorModel(
    @SerializedName("code") val code: Int?,
    @SerializedName("message") val message: String?
)