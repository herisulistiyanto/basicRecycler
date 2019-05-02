package com.andro.indie.school

import android.app.Application
import com.andro.indie.school.common.di.studentAppModules
import org.koin.android.ext.android.startKoin

/**
 * Created by herisulistiyanto on 10/02/19.
 * KjokenKoddinger
 */

class BasicRecyclerApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, studentAppModules)
    }

}