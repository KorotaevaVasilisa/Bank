package com.example.bank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.bank.api.BankApi
import com.example.bank.database.BinRoomDatabase
import com.example.bank.screen.BinViewModelProviderFactory
import com.example.bank.screen.MainScreen
import com.example.bank.screen.MainViewModel
import com.example.bank.ui.theme.BankTheme

class MainActivity : ComponentActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository =
            Repository(BankApi.retrofitService, BinRoomDatabase.getDatabase(this).binDao())
        val viewModelProviderFactory = BinViewModelProviderFactory(repository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[MainViewModel::class.java]
        setContent {
            BankTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    MainScreen(mainViewModel = viewModel)
                }
            }
        }
    }
}

