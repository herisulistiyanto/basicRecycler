package com.andro.indie.school.common.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Created by herisulistiyanto on 10/02/19.
 * KjokenKoddinger
 */

abstract class BaseActivity: AppCompatActivity() {

    protected fun <T> LiveData<T>.onResult(action: (T) -> Unit) {
        observe(this@BaseActivity, Observer { data -> data?.let(action) })
    }

}