package com.example.bank.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bank.Bin
import com.example.bank.api.BankApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _bin = MutableStateFlow<Bin>(Bin())
    val bin: StateFlow<Bin> = _bin.asStateFlow()

    fun getBin(bin: String) {
        viewModelScope.launch {
            try {
                _bin.value = BankApi.retrofitService.getBin(bin = bin).toBin()
            } catch (e: Exception) {
                print("Ошибка запроса")
            }
        }
    }
}
