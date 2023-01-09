package com.app.yelpm.di

import com.app.yelpm.BuildConfig
import com.app.yelpm.network.YelpFusionApiService
import com.app.yelpm.network.model.BusinessDTOMapper
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideBusinessMapper(): BusinessDTOMapper {
        return BusinessDTOMapper()
    }
    @Singleton
    @Provides
    fun provideYelpFusionAPIService(): YelpFusionApiService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.YELP_FUSION_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(OkHttpClient.Builder().addInterceptor { chain ->
                val request = chain.request().newBuilder().addHeader("Authorization", "Bearer ${BuildConfig.YELP_FUSION_API_KEY}").build()
                chain.proceed(request)
            }.build())
            .build()
            .create(YelpFusionApiService::class.java)
    }
}