package com.app.yelpm.repository

import com.app.yelpm.network.YelpFusionApiService
import com.app.yelpm.network.model.BusinessDTOMapper
import com.app.yelpm.network.response.BusinessesSearchResponse

class BusinessesRepositoryImpl(
    private val yelpFusionService: YelpFusionApiService,
    private val dtoMapper: BusinessDTOMapper,
): BusinessesRepository {
    override suspend fun search(location: String): BusinessesSearchResponse {
        return yelpFusionService.businessesSearch(location = location)
    }
}