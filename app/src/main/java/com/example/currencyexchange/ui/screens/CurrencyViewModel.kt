package com.example.currencyexchange.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.currencyexchange.api.RetrofitInstance
import com.example.currencyexchange.model.CurrencyApiResponse
import kotlinx.coroutines.launch

class CurrencyViewModel : ViewModel() {
    var data by mutableStateOf<CurrencyApiResponse?>(null)
        private set
    fun fetchRates(code: String) {

        /*

            viewModelScope → scope powiązany z ViewModel (żyje dopóki ekran istnieje)
            launch → uruchamia coroutine (zadanie w tle, np. request do API)
            całość = bezpieczne wykonanie operacji asynchronicznej bez blokowania UI

         */

        viewModelScope.launch {
            data = RetrofitInstance.api.getCurrencyByCode(code)
        }
    }



}