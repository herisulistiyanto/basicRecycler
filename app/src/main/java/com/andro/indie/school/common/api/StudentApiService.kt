package com.andro.indie.school.common.api

import com.andro.indie.school.data.remote.request.StudentRequest
import com.andro.indie.school.data.remote.response.AddStudentResponse
import com.andro.indie.school.data.remote.response.GetAllStudentsResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by herisulistiyanto on 10/02/19.
 * KjokenKoddinger
 */

interface StudentApiService {

    @POST("/api/v1/student/")
    fun addStudent(
        @Body student: StudentRequest
    ): Single<AddStudentResponse>

    @GET("/api/v1/student/all")
    fun getAllStudents(): Single<GetAllStudentsResponse>

}