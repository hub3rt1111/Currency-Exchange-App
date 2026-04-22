package com.example.currencyexchange.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyexchange.api.RetrofitInstance
import kotlinx.coroutines.launch

class CurrencyViewModel : ViewModel() {

    fun fetchRates(code: String) {

        /*

            viewModelScope → scope powiązany z ViewModel (żyje dopóki ekran istnieje)
            launch → uruchamia coroutine (zadanie w tle, np. request do API)
            całość = bezpieczne wykonanie operacji asynchronicznej bez blokowania UI

         */

        viewModelScope.launch {
            val res = RetrofitInstance.api.getCurrencyByCode(code)
        }
    }

}