package com.app.yelpm.repository

import com.app.yelpm.network.response.BusinessesSearchResponse

interface BusinessesRepository {
    suspend fun search(location: String): BusinessesSearchResponse
}