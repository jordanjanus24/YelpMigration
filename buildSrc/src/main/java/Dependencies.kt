object Versions {
    // Secrets Gradle Plugin
    const val secrets_gradle_plugin = "2.0.1"
    // AndroidX
    const val androidx_core = "1.9.0"
    const val androidx_lifecycle = "2.5.1"
    const val androidx_activity = "1.6.1"
    const val androidx_appcompat = "1.5.1"
    const val androidx_fragment = "1.5.5"
    // Compose
    const val compose_ui = "1.3.2"
    const val compose_material = "1.3.1"
    const val compose_navigation = "2.5.3"
    // Hilt
    const val hilt = "2.42"
    // Google Maps
    const val play_services_maps = "18.1.0"
    const val play_services_location = "21.0.1"
    const val maps_compose = "2.8.0"
    const val maps_sdk = "3.2.1"
    // Glide
    const val glide = "4.12.0"
    // Retrofit
    const val retrofit = "2.9.0"
    object Testing {
        const val junit = "4.13.2"
        const val androidx_junit = "1.1.5"
        const val espresso_core = "3.5.1"
    }

}
object GlobalDeps {
    const val secrets_gradle_plugin = "com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:${Versions.secrets_gradle_plugin}"
    const val hilt_android_gradle_plugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
}
object Deps {
    // AndroidX
    const val androidx_core = "androidx.core:core:${Versions.androidx_core}"
    const val androidx_core_ktx = "androidx.core:core-ktx:${Versions.androidx_core}"
    const val androidx_lifecycle = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.androidx_lifecycle}"
    const val androidx_appcompat = "androidx.appcompat:appcompat:${Versions.androidx_appcompat}"
    const val androidx_fragment_ktx = "androidx.fragment:fragment-ktx:${Versions.androidx_fragment}"
    // Compose
    const val compose_ui = "androidx.compose.ui:ui:${Versions.compose_ui}"
    const val compose_ui_tooling_preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose_ui}"
    const val compose_activity = "androidx.activity:activity-compose:${Versions.androidx_activity}"
    const val compose_material = "androidx.compose.material:material:${Versions.compose_material}"
    const val compose_navigation =  "androidx.navigation:navigation-compose:${Versions.compose_navigation}"
    //Hilt
    const val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hilt_android_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hilt_compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    //Google Maps
    const val play_services_maps = "com.google.android.gms:play-services-maps:${Versions.play_services_maps}"
    const val play_services_location = "com.google.android.gms:play-services-location:${Versions.play_services_location}"
    const val maps_compose = "com.google.maps.android:maps-compose:${Versions.maps_compose}"
    const val maps_ktx = "com.google.maps.android:maps-ktx:${Versions.maps_sdk}"
    const val maps_utils_ktx = "com.google.maps.android:maps-utils-ktx:${Versions.maps_sdk}"
    // Glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
}

object TestDeps {
    const val junit = "junit:junit:${Versions.Testing.junit}"
    const val androidx_junit = "androidx.test.ext:junit:${Versions.Testing.androidx_junit}"
    const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.Testing.espresso_core}"
    const val compose_test = "androidx.compose.ui:ui-test-junit4:${Versions.compose_ui}"
}
object DebugDeps {
    const val ui_tooling = "androidx.compose.ui:ui-tooling:${Versions.compose_ui}"
    const val ui_test_manifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose_ui}"
}