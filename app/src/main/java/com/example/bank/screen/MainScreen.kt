package com.example.bank.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bank.R

@Composable
fun MainScreen(
    mainViewModel: MainViewModel = viewModel(),
    modifier: Modifier = Modifier,
) {
    val bin = mainViewModel.bin.collectAsState()
    val history = mainViewModel.history.collectAsState()
    var inputBin by remember { mutableStateOf("") }

    Column(modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        OutlinedTextField(value = inputBin,
            onValueChange = { inputBin = it },
            singleLine = true,
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            label = { Text(text = stringResource(id = R.string.bin)) },
            placeholder = { Text(text = stringResource(id = R.string.search)) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Green, // цвет при получении фокуса
                unfocusedBorderColor = Color.LightGray  // цвет при отсутствии фокуса
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            trailingIcon = {
                IconButton(onClick = {
                    mainViewModel.getBin(inputBin)
                    println(inputBin)
                },
                    enabled = inputBin.length >= 4)
                {
                    Icon(imageVector = Icons.Default.Search,
                        contentDescription = stringResource(id = R.string.search),
                        tint = Color.Black)
                }
            }
        )
        CardOfInfo(bin = bin.value)

        Text(
            modifier = modifier.padding(vertical = 6.dp),
            text = stringResource(id = R.string.history),
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
        )

        LazyColumn {
            items(items = history.value, itemContent = { item -> CardOfInfo(bin = item) })
        }
    }
}
