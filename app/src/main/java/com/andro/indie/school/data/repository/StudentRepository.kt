package com.andro.indie.school.data.repository

import com.andro.indie.school.common.api.StudentApiService
import com.andro.indie.school.data.remote.request.StudentRequest
import com.andro.indie.school.data.remote.response.AddStudentResponse
import com.andro.indie.school.data.remote.response.GetAllStudentsResponse
import io.reactivex.Single

/**
 * Created by herisulistiyanto on 10/02/19.
 * KjokenKoddinger
 */

class StudentRepository(private val apiService: StudentApiService) {

    fun addNewStudent(student: StudentRequest): Single<AddStudentResponse> {
        return apiService.addStudent(student)
    }

    fun getAllStudents(): Single<GetAllStudentsResponse> {
        return apiService.getAllStudents()
    }

}