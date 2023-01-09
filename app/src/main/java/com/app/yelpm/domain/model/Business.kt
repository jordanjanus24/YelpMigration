package com.app.yelpm.domain.model


data class Address(
    val address1: String? = null,
    val address2: String? = null,
    val address3: String? = null,
    val city: String? = null,
    val zipCode: String? = null,
    val country: String? = null,
    val state: String? = null,
    val displayAddress: List<String>? = null,
)
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
)