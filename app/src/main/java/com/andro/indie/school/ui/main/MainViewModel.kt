package com.andro.indie.school.ui.main

import androidx.annotation.IdRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.andro.indie.school.R
import com.andro.indie.school.common.base.BaseViewModel

/**
 * Created by herisulistiyanto on 10/02/19.
 * KjokenKoddinger
 */

class MainViewModel: BaseViewModel() {

    private val selectedNavigationId = MutableLiveData<Int>()

    init {
        setSelectedNavigationId(R.id.navOld)
    }

    fun setSelectedNavigationId(@IdRes id: Int) {
        selectedNavigationId.value = id
    }

    fun getSelectedNavigationId(): LiveData<Int> {
        return selectedNavigationId
    }

}