package com.example.currencyexchange.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currencyexchange.model.MyCurrency
import com.example.currencyexchange.ui.components.CurrencyPanel
import com.example.currencyexchange.ui.theme.DarkerLightGray
import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.collections.iterator

@Composable
fun FavoriteScreen(viewModel: CurrencyViewModel, modifier: Modifier = Modifier) {

    val usd = MyCurrency("USD", 4.32, -1.12)
    val gbp = MyCurrency("GBP", 3.13, 0.52)
    val eur = MyCurrency("EUR", 1.02, -0.11)
    val chf = MyCurrency("CHF", 2.21, 2.22)
    val pln = MyCurrency("PLN", 0.11, 3.09)

    val currencyList = listOf(usd, gbp, eur, chf, pln)
    var searchQuery by remember { mutableStateOf("") }
    val allCurrenciesList = createCurrencyList(viewModel)

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
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
        )

        val filteredFav = currencyList.filter {
            it.currencyCode.contains(searchQuery, ignoreCase = true)
        }
        val filteredAll = allCurrenciesList.filter {
            it.currencyCode.contains(searchQuery, ignoreCase = true)
        }

        DisplayPanels(filteredFav, "Favorite", modifier = Modifier.weight(1f), true)
        DisplayPanels(filteredAll, "Available", modifier = Modifier.weight(1f), false)
    }
}

@Composable
fun DisplayPanels(currencyList: List<MyCurrency>, text: String, modifier: Modifier = Modifier, isFavorite: Boolean) {
    Column(
        modifier = modifier
            .padding(8.dp)
    ) {
        Text(
            text,
            modifier = Modifier.padding(4.dp),
            fontSize = 24.sp
        )

        LazyColumn() {
            items(currencyList) { item ->
                CurrencyPanel(Modifier, item, 1, isFavorite)
            }
        }
    }
}

fun createCurrencyList(viewModel: CurrencyViewModel): List<MyCurrency> {
    val currenciesList = mutableListOf<MyCurrency>()
    viewModel.data?.let { data ->
        currenciesList.clear()
        for ((key, value) in data.conversionRates) {
            val currency = MyCurrency(key, value, 0.0)
            currenciesList.add(currency)
        }
    }
    return currenciesList
}