plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.sdklibrary"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(files("libs/API3_READER-release-2.0.3.148.jar"))
    implementation(files("libs/API3_CMN-release-2.0.3.148.jar"))
    implementation(files("libs/BarcodeScannerLibrary-release-11.jar"))
    implementation(files("libs/API3_ASCII-release-2.0.3.148.jar"))
    implementation(files("libs/API3_INTERFACE-release-2.0.3.148.jar"))
    implementation(files("libs/API3_LLRP-release-2.0.3.148.jar"))
    implementation(files("libs/API3_TRANSPORT-release-2.0.3.148.jar"))
    implementation(files("libs/API3_ZIOTC-release-2.0.3.148.jar"))
    implementation(files("libs/API3_ZIOTCTRANSPORT-release-2.0.3.148.jar"))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))

    implementation ("com.journeyapps:zxing-android-embedded:4.3.0")

}