package com.example.bank.api

import com.example.bank.api.model.Info
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{bin}")
    suspend fun getBin(@Path("bin") bin: String): Info
}

val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

val retrofit: Retrofit =
    Retrofit.Builder()
        .baseUrl("https://lookup.binlist.net/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

object BankApi {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}
