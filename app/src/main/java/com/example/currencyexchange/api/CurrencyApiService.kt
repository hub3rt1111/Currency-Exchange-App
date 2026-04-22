package com.example.currencyexchange.api

import com.example.currencyexchange.model.CurrencyApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CurrencyApiService {

    @GET("latest/{code}")
    suspend fun getCurrencyByCode(@Path("code") code: String): CurrencyApiResponse

}