package com.example.androidarchitecture.data.model

import androidx.room.Embedded

data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    @Embedded(prefix = "geo_")
    val geo: Geo
)

data class Geo(
    val lat: String,
    val lng: String
)