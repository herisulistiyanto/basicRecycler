package com.andro.indie.school.ui.main.fragments.mid

import com.andro.indie.school.common.base.BaseViewModel
import com.andro.indie.school.data.remote.response.GetAllStudentsResponse
import com.andro.indie.school.data.repository.StudentRepository

/**
 * Created by herisulistiyanto on 10/02/19.
 * KjokenKoddinger
 */

class MidViewModel(private val repository: StudentRepository) : BaseViewModel() {

    fun loadAllStudents(action: (GetAllStudentsResponse) -> Unit) {
        repository.getAllStudents().onResult {
            action.invoke(it)
        }
    }

}