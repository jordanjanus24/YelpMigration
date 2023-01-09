package com.app.yelpm.di

import com.app.yelpm.network.YelpFusionApiService
import com.app.yelpm.network.model.BusinessDTOMapper
import com.app.yelpm.repository.BusinessesRepository
import com.app.yelpm.repository.BusinessesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideBusinessesRepository(
        yelpFusionService: YelpFusionApiService,
        businessMapper: BusinessDTOMapper,
    ): BusinessesRepository {
        return BusinessesRepositoryImpl(
            yelpFusionService = yelpFusionService,
            dtoMapper = businessMapper
        )
    }
}