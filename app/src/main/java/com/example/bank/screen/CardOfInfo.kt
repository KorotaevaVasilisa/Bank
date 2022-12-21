package com.example.bank.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bank.R

@Composable
fun CardOfInfo(modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(8.dp)) {
        Row(modifier = modifier.fillMaxWidth()) {
            Column(modifier = modifier
                .weight(1f)
                .padding(8.dp)) {
                Text(text = stringResource(id = R.string.bank),
                    style = TextStyle(fontWeight = FontWeight.Bold))
                Text(text = "Jyske Bank", maxLines = 1)
                Text(text = "www.jyskebank.dk", maxLines = 1)
                Text(text = "+4589893300", maxLines = 1)
                Spacer(modifier = modifier.height(16.dp))
                Text(text = stringResource(id = R.string.country),
                    style = TextStyle(fontWeight = FontWeight.Bold))
                Text(text = "Denmark", maxLines = 1)
            }
            Column(modifier = modifier
                .weight(1f)
                .padding(8.dp)) {
                Text(text = stringResource(id = R.string.network),
                    style = TextStyle(fontWeight = FontWeight.Bold))
                Text(text = "Visa", maxLines = 1)
                Text(text = stringResource(id = R.string.brand),
                    style = TextStyle(fontWeight = FontWeight.Bold))
                Text(text = "Visa/Dankort", maxLines = 1)
                Text(text = stringResource(id = R.string.type),
                    style = TextStyle(fontWeight = FontWeight.Bold))
                Text(text = "debit", maxLines = 1)
                Text(text = stringResource(id = R.string.prepaid),
                    style = TextStyle(fontWeight = FontWeight.Bold))
                Text(text = "No", maxLines = 1)
            }
        }
    }
}

@Preview
@Composable
fun ShowCardOfInfo() {
    CardOfInfo()
}