package com.app.yelpm.network

import com.app.yelpm.network.response.BusinessesSearchResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface YelpFusionApiService {

    @GET("businesses/search")
    suspend fun businessesSearch(
        @Query("location") location: String,
    ): BusinessesSearchResponse
}