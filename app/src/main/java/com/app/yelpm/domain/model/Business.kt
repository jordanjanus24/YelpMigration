package com.app.yelpm.domain.model


data class Address(
    val address1: String? = "",
    val address2: String? = "",
    val address3: String? = "",
    val city: String? = "",
    val zipCode: String? = "",
    val country: String? = "",
    val state: String? = "",
    val displayAddress: List<String>? = null,
){
    fun getDisplayAddress(): String {
        return "$address1 $city $zipCode"
    }
}
data class Coordinates(
    val latitude: Double? = null,
    val longitude: Double? = null
)
data class Category(
    val alias: String? = null,
    val title: String? = null
)
data class Business(
    val id: String? = null,
    val alias: String? = null,
    val name: String? = null,
    val imageUrl: String? = null,
    val isClosed: Boolean? = null,
    val url: String? = null,
    val reviewCount: Int? = null,
    val categories: List<Category>? = null,
    val rating: Float? = null,
    val coordinates: Coordinates? = null,
    val location: Address? = null,
    val phone: String? = null,
    val displayPhone: String? = null,
    val distance: Double? = null
) {
    fun getCategories(): String {
        categories?.let {
            return categories.joinToString(separator = ", ") { "${it.title}" }
        }
        return ""
    }
}