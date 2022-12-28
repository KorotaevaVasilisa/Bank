package com.example.bank.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bank.Repository
import com.example.bank.database.BinEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import java.net.ConnectException
import java.net.SocketException

class MainViewModel(
    private val retrofitRepository: Repository,
) : ViewModel() {

    private val _bin = MutableStateFlow<BinEntity>(BinEntity())
    val bin: StateFlow<BinEntity> = _bin.asStateFlow()

    private val _history = MutableStateFlow<List<BinEntity>>(emptyList())
    val history: StateFlow<List<BinEntity>> = _history.asStateFlow()

    init {
        viewModelScope.launch {
            _history.value = retrofitRepository.getBins()
        }
    }

    fun getBin(binInput: String) {
        viewModelScope.launch {
            try {
                _history.value = retrofitRepository.getBins()
                _bin.value = retrofitRepository.getBin(bin = binInput).toBin(binInput)
                retrofitRepository.insertBin(bin.value)

            } catch (e: ConnectException) {
                Log.e("ERROR", "ConnectException: " + e.localizedMessage)
            } catch (e: SocketException) {
                Log.e("ERROR", "SocketException: " + e.localizedMessage)
            } catch (e: IOException) {
                Log.e("ERROR", "IOE ERROR: " + e.localizedMessage)
            } catch (e: HttpException) {
                Log.e("ERROR", "HTTP ERROR: " + e.localizedMessage)
            }
        }
    }
}
