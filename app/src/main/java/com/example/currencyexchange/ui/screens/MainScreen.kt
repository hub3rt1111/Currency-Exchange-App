package com.example.currencyexchange.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.currencyexchange.ui.theme.DarkRed
import com.example.currencyexchange.ui.theme.DarkerLightGray
import com.example.currencyexchange.ui.theme.LightRed

@Composable
fun MainScreen(viewModel: CurrencyViewModel, modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomBar(navController)
        }
    )
    { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { HomeScreen(viewModel) }
            composable("fav") { FavoriteScreen(viewModel) }
            composable("settings") { SettingsScreen() }
        }
    }

}

@Composable
fun HomeScreen(viewModel: CurrencyViewModel, modifier: Modifier = Modifier) {
    LaunchedEffect(Unit) {
        viewModel.fetchRates("PLN")
    }

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

//        LazyColumn {
//            items(currenciesList) { item ->
//                CurrencyPanel(item)
//            }
//        }
    }
}

@Composable
fun BottomBar(
    navController: NavController,
) {
    val currentRoute =
        navController
            .currentBackStackEntryAsState() // obserwuje aktualny ekran (auto refresh UI)
            .value                          // bierze aktualny stan
            ?.destination                   // aktualny ekran (destination)
            ?.route                         // jego nazwa np. "home", "fav", "settings"

    NavigationBar {
        NavigationBarItem(
            selected = currentRoute == "home",
            onClick = { navController.navigate("home") },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = currentRoute == "fav",
            onClick = { navController.navigate("fav") },
            icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite") },
            label = { Text("Favorite") }
        )
        NavigationBarItem(
            selected = currentRoute == "settings",
            onClick = { navController.navigate("settings") },
            icon = { Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings") },
            label = { Text("Settings") }
        )
    }
}