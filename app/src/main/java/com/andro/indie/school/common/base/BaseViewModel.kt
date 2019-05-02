package com.andro.indie.school.common.base

import androidx.annotation.CallSuper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by herisulistiyanto on 10/02/19.
 * KjokenKoddinger
 */

abstract class BaseViewModel : ViewModel() {

    private val disposables = CompositeDisposable()
    private var error = MutableLiveData<String>()
    private val isLoading = MutableLiveData<Boolean>()
    protected val isEmptyData = MutableLiveData<Boolean>()

    fun observeError(): LiveData<String> = error
    fun observeLoading(): LiveData<Boolean> = isLoading
    fun observeEmpty(): LiveData<Boolean> = isEmptyData

    private fun launch(job: () -> Disposable) {
        disposables.add(job())
    }

    protected fun <T> Single<T>.onResult(action: (T) -> Unit) {
        launch {
            this.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe {
                    isLoading.postValue(true)
                }
                .doOnError {
                    isLoading.postValue(false)
                }
                .doOnSuccess {
                    isLoading.postValue(false)
                }
                .subscribe(
                    { result -> action.invoke(result) },
                    { cause -> error.postValue(cause?.message) }
                )
        }
    }

    @CallSuper
    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

}