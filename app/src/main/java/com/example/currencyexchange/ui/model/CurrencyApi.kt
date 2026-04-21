package com.example.currencyexchange.ui.model

import com.google.gson.annotations.SerializedName

data class CurrencyApi(

    @SerializedName("result")
    val result: String,

    @SerializedName("base_code")
    val baseCode: String,

    @SerializedName("conversion_rates")
    val conversionRates: Map<Int, String>

)