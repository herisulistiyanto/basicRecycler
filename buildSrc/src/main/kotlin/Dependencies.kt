/**
 * Created by herisulistiyanto on 30/04/19.
 * KjokenKoddinger
 */

object Dependencies {

    object AndroidLib {
        const val ktx = "androidx.core:core-ktx:${DepsConstant.LibVersion.coreKtx}"
        const val appCompat = "androidx.appcompat:appcompat:${DepsConstant.LibVersion.appCompat}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${DepsConstant.LibVersion.constraintLayout}"
        const val cardView = "androidx.cardview:cardview:${DepsConstant.LibVersion.cardView}"
        const val recyclerView = "androidx.recyclerview:recyclerview:${DepsConstant.LibVersion.recyclerView}"
        const val material = "com.google.android.material:material:${DepsConstant.LibVersion.material}"
    }

    object NavigationLib {
        const val navFragment = "android.arch.navigation:navigation-fragment-ktx:${DepsConstant.LibVersion.navFragment}"
        const val navUi = "android.arch.navigation:navigation-ui-ktx:${DepsConstant.LibVersion.navUi}"
    }

    object LifecycleLib {
        const val compiler = "androidx.lifecycle:lifecycle-compiler:${DepsConstant.LibVersion.lifecycleCompiler}"
        const val extension = "androidx.lifecycle:lifecycle-extensions:${DepsConstant.LibVersion.lifecycleExt}"
        const val livedata = "androidx.lifecycle:lifecycle-livedata:${DepsConstant.LibVersion.livedata}"
        const val livedataCore = "androidx.lifecycle:lifecycle-livedata-core:${DepsConstant.LibVersion.livedataCore}"
        const val reactive = "androidx.lifecycle:lifecycle-reactivestreams:${DepsConstant.LibVersion.livedataReactiveStream}"
        const val runtime = "androidx.lifecycle:lifecycle-runtime:${DepsConstant.LibVersion.lifecycleRuntime}"
        const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel:${DepsConstant.LibVersion.lifecycleViewModel}"
    }

    object RxLib {
        const val rxJava = "io.reactivex.rxjava2:rxjava:${DepsConstant.LibVersion.rxJava}"
        const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${DepsConstant.LibVersion.rxAndroid}"
    }

    object KoinLib {
        const val koinAndroid = "org.koin:koin-android:${DepsConstant.LibVersion.koinAndroid}"
        const val koinScope = "org.koin:koin-androidx-scope:${DepsConstant.LibVersion.koinScope}"
        const val koinViewModel = "org.koin:koin-androidx-viewmodel:${DepsConstant.LibVersion.koinViewModel}"
    }

    object RetrofitLib {
        const val retrofit = "com.squareup.retrofit2:retrofit:${DepsConstant.LibVersion.retrofit}"
        const val retrofitRx = "com.squareup.retrofit2:adapter-rxjava2:${DepsConstant.LibVersion.retrofitRxAdapter}"
        const val retrofitGson = "com.squareup.retrofit2:converter-gson:${DepsConstant.LibVersion.retrofitGsonAdapter}"
    }

    object OkHttpLib {
        const val okhttp = "com.squareup.okhttp3:okhttp:${DepsConstant.LibVersion.okhttp}"
        const val okhttpLog = "com.squareup.okhttp3:logging-interceptor:${DepsConstant.LibVersion.okhttpLog}"
    }

    object LottieLib {
        const val lottie = "com.airbnb.android:lottie:${DepsConstant.LibVersion.lottie}"
    }

    object TestLib {
        const val junit = "junit:junit:${DepsConstant.LibTestVersion.junit}"
    }

    object AndroidTestLib {
        const val testRunner = "androidx.test:runner:${DepsConstant.LibAndroidTestVersion.testRunner}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${DepsConstant.LibAndroidTestVersion.espressoCore}"
    }

    fun getAndroidLibs(): List<Pair<String, LibType>> {
        return listOf<Pair<String, LibType>>(
            AndroidLib.appCompat to LibType.Library,
            AndroidLib.ktx to LibType.Library,
            AndroidLib.cardView to LibType.Library,
            AndroidLib.constraintLayout to LibType.Library,
            AndroidLib.recyclerView to LibType.Library,
            AndroidLib.material to LibType.Library
        )
    }

    fun getNavLibs(): List<Pair<String, LibType>> {
        return listOf<Pair<String, LibType>>(
            NavigationLib.navFragment to LibType.Library,
            NavigationLib.navUi to LibType.Library
        )
    }

    fun getLifecycleLibs(): List<Pair<String, LibType>> {
        return listOf<Pair<String, LibType>>(
            LifecycleLib.compiler to LibType.Compiler,
            LifecycleLib.extension to LibType.Library,
            LifecycleLib.livedata to LibType.Library,
            LifecycleLib.livedataCore to LibType.Library,
            LifecycleLib.reactive to LibType.Library,
            LifecycleLib.runtime to LibType.Library,
            LifecycleLib.viewmodel to LibType.Library
        )
    }

    fun getDepsInjectionLibs(): List<Pair<String, LibType>> {
        return listOf<Pair<String, LibType>>(
            KoinLib.koinAndroid to LibType.Library,
            KoinLib.koinScope to LibType.Library,
            KoinLib.koinViewModel to LibType.Library
        )
    }

    fun getNetworkLibs(): List<Pair<String, LibType>> {
        return listOf<Pair<String, LibType>>(
            RxLib.rxJava to LibType.Library,
            RxLib.rxAndroid to LibType.Library,
            RetrofitLib.retrofit to LibType.Library,
            RetrofitLib.retrofitGson to LibType.Library,
            RetrofitLib.retrofitRx to LibType.Library,
            OkHttpLib.okhttp to LibType.Library,
            OkHttpLib.okhttpLog to LibType.Library
        )
    }

    fun getCustomUiLibs(): List<Pair<String, LibType>> {
        return listOf<Pair<String, LibType>>(
            LottieLib.lottie to LibType.Library
        )
    }

    fun getTestLibs(): List<Pair<String, LibType>> {
        return listOf<Pair<String, LibType>>(
            TestLib.junit to LibType.TestLib
        )
    }

    fun getAndroidTestLibs(): List<Pair<String, LibType>> {
        return listOf<Pair<String, LibType>>(
            AndroidTestLib.testRunner to LibType.AndroidTestLib,
            AndroidTestLib.espressoCore to LibType.AndroidTestLib
        )
    }
}

sealed class LibType {
    object Library: LibType()
    object Compiler: LibType()
    object TestLib: LibType()
    object AndroidTestLib: LibType()
}