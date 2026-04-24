package com.example.currencyexchange.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.currencyexchange.model.MyCurrency
import com.example.currencyexchange.ui.components.CurrencyPanel
import com.example.currencyexchange.ui.theme.DarkerLightGray

@Composable
@Preview
fun FavoriteScreen(modifier: Modifier = Modifier) {

    val usd = MyCurrency("USD", 4.32, -1.12)
    val gbp = MyCurrency("GBP", 3.13, 0.52)
    val eur = MyCurrency("EUR", 1.02, -0.11)
    val chf = MyCurrency("CHF", 2.21, 2.22)
    val pln = MyCurrency("PLN", 0.11, 3.09)
    val currencyList = listOf(usd, gbp, eur, chf, pln)
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(DarkerLightGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search") },
            modifier = Modifier.fillMaxWidth()
        )

        val filtered = currencyList.filter {
            it.currencyCode.contains(searchQuery, ignoreCase = true)
        }

        DisplayPanels(filtered, "Favorite")
        DisplayPanels(filtered, "Available")
    }
}

@Composable
fun DisplayPanels(currencyList: List<MyCurrency>, text: String) {
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(text)
        LazyColumn() {
            items(currencyList) { item ->
                CurrencyPanel(item)
            }
        }
    }
}