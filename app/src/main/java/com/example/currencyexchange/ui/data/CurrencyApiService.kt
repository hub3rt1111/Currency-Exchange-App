package com.example.currencyexchange.ui.data

import com.example.currencyexchange.ui.model.CurrencyApi
import com.example.currencyexchange.ui.model.MyCurrency
import retrofit2.http.GET
import retrofit2.http.Path

interface CurrencyApiService {

    @GET("currencies/{code}")
    suspend fun getCurrencyByCode(@Path("code")code: String): CurrencyApi
}