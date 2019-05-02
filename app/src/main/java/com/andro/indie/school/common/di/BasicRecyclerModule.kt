package com.andro.indie.school.common.di

import com.andro.indie.school.BuildConfig
import com.andro.indie.school.common.api.StudentApiService
import com.andro.indie.school.common.custom.DiffCallback
import com.andro.indie.school.data.repository.StudentRepository
import com.andro.indie.school.ui.main.MainViewModel
import com.andro.indie.school.ui.main.fragments.mid.MidViewModel
import com.andro.indie.school.ui.main.fragments.old.OldViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by herisulistiyanto on 10/02/19.
 * KjokenKoddinger
 */
 
val appModules: Module = module {
    single { provideOkHttpClient() } //OkHttpClient
    single { provideStudentApiService(get(), BuildConfig.BASE_URL) }
    single { StudentRepository(get()) }
    single { DiffCallback() }
}

val viewModelModules: Module = module {
    viewModel { OldViewModel(get()) }
    viewModel { MidViewModel(get()) }
    viewModel { MainViewModel() }
}

val studentAppModules = listOf(appModules, viewModelModules)

fun provideOkHttpClient(): OkHttpClient {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY

    return OkHttpClient.Builder()
        .addInterceptor(logging)
        .connectTimeout(60L, TimeUnit.SECONDS)
        .writeTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .build()
}

fun provideStudentApiService(client: OkHttpClient, baseUrl: String): StudentApiService {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(StudentApiService::class.java)
}