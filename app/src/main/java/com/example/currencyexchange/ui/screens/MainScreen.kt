package com.example.currencyexchange.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.currencyexchange.ui.components.CurrencyItem
import com.example.currencyexchange.ui.model.MyCurrency

@Preview
@Composable
fun MainScreen(modifier : Modifier = Modifier) {

    val usd = MyCurrency("USD", 4.32, -1.12, "Dolar Amerykański")
    val gbp = MyCurrency("GBP", 3.13, 0.52, "Funt Brytyjski")
    val eur = MyCurrency("EUR", 1.02, -0.11, "Euro")
    val chf = MyCurrency("CHF", 2.21, 2.22, "Frank Szwajcarski")
    val pln = MyCurrency("PLN", 0.11, 3.09, "Polski Złoty")

    Column(
        modifier.padding(16.dp)
    ) {
        Text("Ostatnia aktualizacja: ")
        Text("Waluta bazowa: 1 PLN")

        CurrencyItem(usd)
        CurrencyItem(gbp)
        CurrencyItem(eur)
        CurrencyItem(chf)
        CurrencyItem(pln)
    }


}