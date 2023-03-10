package com.app.yelpm.repository

import com.app.yelpm.domain.model.Business
import com.app.yelpm.network.YelpFusionApiService
import com.app.yelpm.network.model.BusinessDTOMapper

class BusinessesRepositoryImpl(
    private val yelpFusionService: YelpFusionApiService,
    private val dtoMapper: BusinessDTOMapper,
): BusinessesRepository {
    override suspend fun search(location: String): List<Business> {
        val response = yelpFusionService.businessesSearch(location = location).businesses
        response?.let {
            return dtoMapper.toDomainList(it)
        }
        return listOf()
    }
}