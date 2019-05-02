package com.andro.indie.school.data.remote.response

import com.andro.indie.school.data.model.ErrorModel
import com.andro.indie.school.data.model.StudentModel
import com.google.gson.annotations.SerializedName

/**
 * Created by herisulistiyanto on 10/02/19.
 * KjokenKoddinger
 */

data class GetAllStudentsResponse(
    @SerializedName("status") val status: String?,
    @SerializedName("data") val data: List<StudentModel>?,
    @SerializedName("error") val error: ErrorModel?
) {
    fun getStudents(): List<StudentModel> {
        return when {
            this.data == null -> emptyList()
            else -> this.data
        }
    }
}