package com.example.bank.api

import com.example.bank.api.model.Info
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{bin}")
    suspend fun getBin(@Path("bin") bin: String): Info
}
