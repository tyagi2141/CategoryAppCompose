plugins {
    // id("com.android.application")
    // id("org.jetbrains.kotlin.android")

    id("com.android.application")
    kotlin("android")

    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization") version "1.8.20"


}

android {
    namespace = "com.example.categoryapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.categoryapp"
        minSdk = 24
        targetSdk = 33
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
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.8.10")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")



    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")

    //  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
    // implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")

// retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
// GSON
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
// coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")


    // Kotlin
    val nav_version = "2.6.0"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-compose:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    implementation("com.google.code.gson:gson:2.9.0") // Gradle KTS

    // implementation("androidx.navigation:navigation-compose:$nav_version")

      implementation("com.google.dagger:hilt-android:2.44")
     kapt("com.google.dagger:hilt-android-compiler:2.44")
      kapt("androidx.hilt:hilt-compiler:1.0.0")
      implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    //implementation ("androidx.hilt:hilt-navigation-compose:$compose_hilt_navigation_version")
    //implementation("androidx.hilt:hilt-navigation-compose:1.0.0")


      //  implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
       // implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")

       // implementation ("androidx.navigation:navigation-compose:2.4.0-alpha05")
        // implementation ("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")





}