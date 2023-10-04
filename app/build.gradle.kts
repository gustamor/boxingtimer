plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "es.gustavomoreno.android.boxingtimer"
    compileSdk = 34

    defaultConfig {
        applicationId = "es.gustavomoreno.android.boxingtimer"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }


    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
   
}

dependencies {
    
    val composeUiVersion = "1.4.3"
    val accompanistVersion = "0.30.1"
    val roomVersion = "2.5.2"
    val retrofitVersion = "2.9.0"
    val lifeCycle = "2.6.1"

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.work:work-runtime-ktx:2.8.1" )// required to avoid crash on Android 12 API 31
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.05.01"))
    implementation("androidx.compose.ui:ui:${composeUiVersion}")
    implementation("androidx.compose.ui:ui-tooling-preview:${composeUiVersion}")
    implementation("androidx.compose.runtime:runtime-livedata:${composeUiVersion}")
    implementation("androidx.compose.material:material")
    implementation("io.coil-kt:coil:2.4.0")
    implementation("io.coil-kt:coil-compose:2.4.0")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${lifeCycle}")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:${lifeCycle}")

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.6.0")

    //Drawable Painter
    implementation("com.google.accompanist:accompanist-drawablepainter:${accompanistVersion}")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:${retrofitVersion}")
    implementation("com.squareup.retrofit2:converter-gson:${retrofitVersion}")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")

    //Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.46.1")
    implementation("androidx.appcompat:appcompat-resources:1.6.1")
    implementation("androidx.room:room-common:2.5.2")
    kapt("com.google.dagger:hilt-android-compiler:2.46.1")
    implementation("androidx.hilt:hilt-work:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    // When using Kotlin.
    kapt("androidx.hilt:hilt-compiler:1.0.0")

    //Fonts
    implementation("androidx.compose.ui:ui-text-google-fonts:1.5.0")

    // Room components
    implementation("androidx.room:room-ktx:${roomVersion}")
    kapt("androidx.room:room-compiler:${roomVersion}")
    implementation("androidx.room:room-runtime:${roomVersion}")
    annotationProcessor("androidx.room:room-compiler:${roomVersion}")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.05.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    androidTestImplementation("androidx.room:room-testing:${roomVersion}")

    // Mockito)
    // required if you want to use Mockito for Android tests
    androidTestImplementation("org.mockito:mockito-android:5.3.1")
    // Hilt for testing
    testImplementation("com.google.dagger:hilt-android-testing:2.46.1")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.46.1")
    kaptTest("com.google.dagger:hilt-android-compiler:2.46.1")
}