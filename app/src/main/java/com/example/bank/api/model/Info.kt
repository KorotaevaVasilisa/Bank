package com.example.bank.api.model


import com.example.bank.Bin
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Info(
    @Json(name = "bank")
    val bank: Bank?,
    @Json(name = "brand")
    val brand: String?,
    @Json(name = "country")
    val country: Country?,
    @Json(name = "prepaid")
    val prepaid: Boolean?,
    @Json(name = "scheme")
    val scheme: String?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "number")
    val number: Number?,
) {
    fun toBin(bin: String): Bin = Bin(
        bin = bin,
        brand = brand ?: "",
        country = country?.currency ?: "",
        prepaid = prepaid ?: true,
        scheme = scheme ?: "",
        type = type ?: "",
        cityBank = bank?.city ?: "",
        nameBank = bank?.name ?: "",
        phoneBank = bank?.phone ?: "",
        urlBank = bank?.url ?: ""
    )
}
