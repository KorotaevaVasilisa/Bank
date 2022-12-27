package com.example.bank.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Country(
    @Json(name = "currency")
    val currency: String?,
    @Json(name = "name")
    val name: String?,
)
