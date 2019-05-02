package com.andro.indie.school.common.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Created by herisulistiyanto on 10/02/19.
 * KjokenKoddinger
 */

abstract class BaseFragment: Fragment() {

    protected fun <T> LiveData<T>.onResult(action: (T) -> Unit) {
        observe(this@BaseFragment, Observer { data -> data?.let(action) })
    }

}