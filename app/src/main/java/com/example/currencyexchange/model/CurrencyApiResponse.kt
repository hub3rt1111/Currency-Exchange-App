package com.example.currencyexchange.model

import com.google.gson.annotations.SerializedName

data class CurrencyApiResponse(

    @SerializedName("result")
    val result: String,

    @SerializedName("base_code")
    val baseCode: String,

    @SerializedName("conversion_rates")
    val conversionRates: Map<String, Double>

)