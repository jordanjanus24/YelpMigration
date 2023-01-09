package com.app.yelpm.repository

import com.app.yelpm.domain.model.Business

interface BusinessesRepository {
    suspend fun search(location: String): List<Business>
}