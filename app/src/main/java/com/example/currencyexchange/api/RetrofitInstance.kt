package com.example.currencyexchange.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    const val API_KEY: String = "708b7b65e0a9d40037c0215b"
    val api: CurrencyApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://v6.exchangerate-api.com/v6/${API_KEY}/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CurrencyApiService::class.java)
    }

}