package com.thechance.myweather.data.response

import com.thechance.myweather.domain.entity.Location
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationResponse(
    @SerialName("as")
    val asX: String?,
    @SerialName("city")
    val city: String?,
    @SerialName("country")
    val country: String?,
    @SerialName("countryCode")
    val countryCode: String?,
    @SerialName("isp")
    val isp: String?,
    @SerialName("lat")
    val lat: Double?,
    @SerialName("lon")
    val lon: Double?,
    @SerialName("org")
    val org: String?,
    @SerialName("query")
    val query: String?,
    @SerialName("region")
    val region: String?,
    @SerialName("regionName")
    val regionName: String?,
    @SerialName("status")
    val status: String?,
    @SerialName("timezone")
    val timezone: String?,
    @SerialName("zip")
    val zip: String?
)

fun LocationResponse.toLocation(): Location{
    return Location(
        latitude = this.lat ?: 0.0,
        longitude = this.lon ?: 0.0,
        cityName = this.city ?: ""
    )
}