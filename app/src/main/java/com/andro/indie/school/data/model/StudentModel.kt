package com.andro.indie.school.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by herisulistiyanto on 10/02/19.
 * KjokenKoddinger
 */

data class StudentModel(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("email") val email: String?
)