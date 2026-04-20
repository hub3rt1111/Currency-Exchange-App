package com.example.currencyexchange.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.currencyexchange.R
import com.example.currencyexchange.ui.data.CurrencyProvider
import com.example.currencyexchange.ui.model.MyCurrency
import com.example.currencyexchange.ui.theme.LightGray


@Composable
fun CurrencyPanel(currency: MyCurrency, modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .background(LightGray)
            .drawBehind {
                val width = 2.dp.toPx()
                drawLine(
                    color = Color.Gray,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = width
                )
            }
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = currency.flagUrl,
                contentDescription = "Flag",
                modifier = Modifier
                    .size(56.dp)
                    .padding(end = 8.dp)
            )

            Column() {
                Text(
                    currency.countryCode,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic
                )
                Text(currency.name)
            }
        }

        Column() {
            Row() {
                Text(
                    "${currency.value} PLN",
                    fontWeight = FontWeight.Bold
                )

                val arrow = if (currency.change < 0) R.drawable.arrowdown else R.drawable.arrowup

                Image(
                    painter = painterResource(id = arrow),
                    contentDescription = "arrow",
                    modifier = Modifier.size(36.dp)
                )
            }
            Text(
                "${currency.change} %"
            )
        }
    }
}

fun getFlag(countryCode: String): Int {
    return when (countryCode) {
        "USD" -> R.drawable.us
        "GBP" -> R.drawable.uk
        "EUR" -> R.drawable.round
        "CHF" -> R.drawable.switzerland
        "PLN" -> R.drawable.poland
        else -> R.drawable.poland
    }
}