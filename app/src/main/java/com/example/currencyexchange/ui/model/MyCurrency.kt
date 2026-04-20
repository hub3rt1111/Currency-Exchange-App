package com.example.currencyexchange.ui.model

import com.example.currencyexchange.ui.data.CurrencyProvider


data class MyCurrency(
    val currencyCode: String, val value: Double, val change: Double
) {
    val countryCode: String =
        CurrencyProvider.currencies[currencyCode]?.countryCode?.uppercase() ?: ""

    val name: String = CurrencyProvider.currencies[currencyCode]?.name ?: ""
    val flagUrl: String = CurrencyProvider.getFlagUrl(currencyCode) ?: ""
}