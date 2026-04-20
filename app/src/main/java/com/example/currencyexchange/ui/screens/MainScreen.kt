package com.example.currencyexchange.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.currencyexchange.ui.components.CurrencyPanel
import com.example.currencyexchange.ui.model.MyCurrency
import com.example.currencyexchange.ui.theme.DarkRed
import com.example.currencyexchange.ui.theme.LightGray
import com.example.currencyexchange.ui.theme.LightRed

@Preview
@Composable
fun MainScreen(modifier : Modifier = Modifier) {

    val usd = MyCurrency("USD", 4.32, -1.12,)
    val gbp = MyCurrency("GBP", 3.13, 0.52)
    val eur = MyCurrency("EUR", 1.02, -0.11)
    val chf = MyCurrency("CHF", 2.21, 2.22)
    val pln = MyCurrency("PLN", 0.11, 3.09)

    Column(
        modifier
            .fillMaxSize()
    ) {
        Text("Ostatnia aktualizacja: ")
        Text("Waluta bazowa: 1 PLN")
        Text(
            "Tryb offline: Brak połączenia z internetem",
            color = DarkRed,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = LightRed, shape = RoundedCornerShape(4.dp))
                .padding(4.dp),
        )

        CurrencyPanel(usd)
        CurrencyPanel(gbp)
        CurrencyPanel(eur)
        CurrencyPanel(chf)
        CurrencyPanel(pln)
    }


}