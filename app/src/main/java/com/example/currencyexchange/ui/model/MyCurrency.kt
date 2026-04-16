package com.example.currencyexchange.ui.model


data class MyCurrency(
    val countryCode : String, val value: Double, val change: Double, val name: String
)