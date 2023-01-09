package com.app.yelpm.network.model

import com.app.yelpm.domain.model.Address
import com.app.yelpm.domain.model.Business
import com.app.yelpm.domain.model.Category
import com.app.yelpm.domain.model.Coordinates
import com.app.yelpm.domain.util.DomainMapper

class BusinessDTOMapper : DomainMapper<BusinessDTO, Business> {
    override fun mapToDomainModel(model: BusinessDTO): Business {
        return Business(
            id = model.id,
            alias = model.alias,
            name = model.name,
            imageUrl = model.imageUrl,
            isClosed = model.isClosed,
            url = model.url,
            reviewCount = model.reviewCount,
            categories = model.categories?.map {
                Category(
                    alias = it.alias,
                    title = it.title
                )
            },
            rating = model.rating,
            coordinates = Coordinates(
                latitude = model.coordinates?.latitude,
                longitude = model.coordinates?.longitude
            ),
            location = Address(
                address1 = model.location?.address1,
                address2 = model.location?.address2,
                address3 = model.location?.address3,
                city = model.location?.city,
                zipCode = model.location?.zipCode,
                country = model.location?.country,
                state = model.location?.state,
                displayAddress = model.location?.displayAddress,
            ),
            phone = model.phone,
            displayPhone = model.displayPhone,
            distance = model.distance
        )
    }

    override fun mapFromDomainModel(model: Business): BusinessDTO {
        return BusinessDTO(
            id = model.id,
            alias = model.alias,
            name = model.name,
            imageUrl = model.imageUrl,
            isClosed = model.isClosed,
            url = model.url,
            reviewCount = model.reviewCount,
            categories = model.categories?.map {
                CategoryDTO(
                    alias = it.alias,
                    title = it.title
                )
            },
            rating = model.rating,
            coordinates = CoordinatesDTO(
                latitude = model.coordinates?.latitude,
                longitude = model.coordinates?.longitude
            ),
            location = AddressDTO(
                address1 = model.location?.address1,
                address2 = model.location?.address2,
                address3 = model.location?.address3,
                city = model.location?.city,
                zipCode = model.location?.zipCode,
                country = model.location?.country,
                state = model.location?.state,
                displayAddress = model.location?.displayAddress,
            ),
            phone = model.phone,
            displayPhone = model.displayPhone,
            distance = model.distance
        )
    }

    fun toDomainList(initial: List<BusinessDTO>): List<Business>{
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Business>): List<BusinessDTO>{
        return initial.map { mapFromDomainModel(it) }
    }
}