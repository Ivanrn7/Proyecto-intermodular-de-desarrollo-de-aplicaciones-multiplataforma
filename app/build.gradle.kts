plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.citafacil"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.citafacil"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = true
                packageScope = setOf("androidx.**", "kotlin.**", "kotlinx.**")
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.activity.ktx)
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.material)
    implementation(libs.play.services.maps)
    testImplementation(libs.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ext.junit)
    // Comunicación con la API REST
    implementation("com.squareup.retrofit2:retrofit:2.11.0")

// Conversión de respuestas JSON a objetos Java
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
}