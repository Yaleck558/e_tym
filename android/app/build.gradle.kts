plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android") // un seul plugin Kotlin suffit
    // Le plugin Flutter doit être appliqué après Android et Kotlin
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.example.e_tym"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.e_tym"
        minSdk = 21
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    // ⚡ CompileOptions et Toolchain doivent être DANS android { ... }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }
}

// KotlinCompile supplémentaire pour s'assurer que jvmTarget = 17 partout
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}

flutter {
    source = "../.."
}
