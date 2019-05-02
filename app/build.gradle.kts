plugins {
    id("com.android.application")
    id("androidx.navigation.safeargs")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "com.andro.indie.school"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "BASE_URL", "\"https://kotlinspringcrud.herokuapp.com/\"")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        setSourceCompatibility(1.8)
        setTargetCompatibility(1.8)
    }

    lintOptions {
        isAbortOnError = false
    }
}

dependencies {

    fun execDeps(listDeps: List<Pair<String, LibType>>) {
        listDeps.forEach{
            when (it.second) {
                is LibType.Library -> implementation(it.first)
                is LibType.Compiler -> kapt(it.first)
                is LibType.TestLib -> testImplementation(it.first)
                is LibType.AndroidTestLib -> androidTestImplementation(it.first)
            }
        }
    }

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${DepsConstant.Kotlin.kotlinVersion}")
    execDeps(Dependencies.getAndroidLibs())
    execDeps(Dependencies.getDepsInjectionLibs())
    execDeps(Dependencies.getLifecycleLibs())
    execDeps(Dependencies.getNavLibs())
    execDeps(Dependencies.getNetworkLibs())
    execDeps(Dependencies.getCustomUiLibs())

    execDeps(Dependencies.getTestLibs())

    execDeps(Dependencies.getAndroidTestLibs())
}