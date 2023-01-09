package com.app.yelpm.network.response

import com.app.yelpm.network.model.BusinessDTO
import com.app.yelpm.network.model.CoordinatesDTO
import com.google.gson.annotations.SerializedName

class BusinessesSearchResponse(
    @SerializedName("businesses")
    var businesses: List<BusinessDTO>? = null,
    @SerializedName("total")
    var total: Int? = null,
    @SerializedName("region")
    var region: RegionResponse? = null
)
class RegionResponse(
    @SerializedName("center")
    var center: CoordinatesDTO? = null
)