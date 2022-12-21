package com.example.bank.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bank.R

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val bin = remember { mutableStateOf(TextFieldValue("")) }
    Column(modifier = modifier.fillMaxSize()) {

        OutlinedTextField(value = bin.value,
            onValueChange = { bin.value = it },
            singleLine = true,
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            label = { Text(text = stringResource(id = R.string.bik)) },
            placeholder = { Text(text = stringResource(id = R.string.search)) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Green, // цвет при получении фокуса
                unfocusedBorderColor = Color.LightGray  // цвет при отсутствии фокуса
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Search,
                        contentDescription = stringResource(id = R.string.search),
                        tint = Color.Black)
                }
            }
        )
        CardOfInfo()

    }
}

@Preview(showBackground = true)
@Composable
fun ShowMainScreen() {
    MainScreen()
}
