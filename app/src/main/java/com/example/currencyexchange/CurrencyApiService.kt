package com.example.currencyexchange

import com.example.currencyexchange.ui.model.MyCurrency
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

interface CurrencyApiService {
    @GET("currencies")
    suspend fun getCurrencies(): List<MyCurrency>

    @GET("currencies/{code}")
    suspend fun getCurrencyByCode(@Path("code")id: Int): MyCurrency
}