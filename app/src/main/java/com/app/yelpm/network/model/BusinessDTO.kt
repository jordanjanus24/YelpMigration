package com.app.yelpm.network.model

import com.google.gson.annotations.SerializedName

class AddressDTO(
    @SerializedName("address1")
    var address1: String? = null,
    @SerializedName("address2")
    var address2: String? = null,
    @SerializedName("address3")
    var address3: String? = null,
    @SerializedName("city")
    var city: String? = null,
    @SerializedName("zip_code")
    var zipCode: String? = null,
    @SerializedName("country")
    var country: String? = null,
    @SerializedName("state")
    var state: String? = null,
    @SerializedName("display_address")
    var displayAddress: List<String>? = null
)
class CoordinatesDTO(
    @SerializedName("latitude")
    var latitude: Double? = null,
    @SerializedName("longitude")
    var longitude: Double? = null
)
class CategoryDTO(
    @SerializedName("alias")
    var alias: String? = null,
    @SerializedName("title")
    var title: String? = null
)
class BusinessDTO(
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("alias")
    var alias: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("image_url")
    var imageUrl: String? = null,
    @SerializedName("is_closed")
    var isClosed: Boolean? = null,
    @SerializedName("url")
    var url: String? = null,
    @SerializedName("review_count")
    var reviewCount: Int? = null,
    @SerializedName("categories")
    var categories: List<CategoryDTO>? = null,
    @SerializedName("rating")
    var rating: Float? = null,
    @SerializedName("coordinates")
    var coordinates: CoordinatesDTO? = null,
    @SerializedName("location")
    var location: AddressDTO? = null,
    @SerializedName("phone")
    var phone: String? = null,
    @SerializedName("display_phone")
    var displayPhone: String? = null,
    @SerializedName("distance")
    var distance: Double? = null
)