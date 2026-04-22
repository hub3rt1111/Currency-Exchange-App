package com.example.currencyexchange.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.currencyexchange.ui.components.CurrencyPanel
import com.example.currencyexchange.model.MyCurrency
import com.example.currencyexchange.ui.theme.DarkRed
import com.example.currencyexchange.ui.theme.DarkerLightGray
import com.example.currencyexchange.ui.theme.LightRed

@Preview
@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomBar(selectedIndex = selectedIndex, onItemSelected = { selectedIndex = it })
        }
    )
    { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding), selectedIndex)
    }

}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex: Int) {

    val usd = MyCurrency("USD", 4.32, -1.12)
    val gbp = MyCurrency("GBP", 3.13, 0.52)
    val eur = MyCurrency("EUR", 1.02, -0.11)
    val chf = MyCurrency("CHF", 2.21, 2.22)
    val pln = MyCurrency("PLN", 0.11, 3.09)
    val pln2 = MyCurrency("PLN", 0.11, 3.09)
    val pln3 = MyCurrency("PLN", 0.11, 3.09)
    val pln4 = MyCurrency("PLN", 0.11, 3.09)
    val pln5 = MyCurrency("PLN", 0.11, 3.09)
    val pln6 = MyCurrency("PLN", 0.11, 3.09)

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(DarkerLightGray)
    ) {

        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            Text("Ostatnia aktualizacja: ", color = Color.Gray)
            Text("Waluta bazowa: PLN", color = Color.Gray)
        }

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                "Tryb offline: Brak połączenia z internetem",
                color = DarkRed,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = LightRed, shape = RoundedCornerShape(4.dp))
                    .padding(8.dp),
            )
        }

        Column(modifier = Modifier.verticalScroll(scrollState)) {
            CurrencyPanel(usd)
            CurrencyPanel(gbp)
            CurrencyPanel(eur)
            CurrencyPanel(chf)
            CurrencyPanel(pln)
            CurrencyPanel(pln)
            CurrencyPanel(pln)
            CurrencyPanel(pln)
            CurrencyPanel(pln)
            CurrencyPanel(pln)
        }

    }
}

@Composable
fun BottomBar(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar {
        NavigationBarItem(
            selected = selectedIndex == 0,
            onClick = { onItemSelected(0) },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = selectedIndex == 1,
            onClick = { onItemSelected(1) },
            icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite") },
            label = { Text("Favorite") }
        )
        NavigationBarItem(
            selected = selectedIndex == 3,
            onClick = { onItemSelected(3) },
            icon = { Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings") },
            label = { Text("Settings") }
        )
    }
}