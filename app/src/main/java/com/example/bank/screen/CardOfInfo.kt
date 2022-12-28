package com.example.bank.screen

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.bank.R
import com.example.bank.database.BinEntity
import com.example.bank.ui.theme.DeepBlue

@Composable
fun CardOfInfo(
    bin: BinEntity,
    modifier: Modifier = Modifier,
) {
    val ctx = LocalContext.current
    Card(modifier = modifier.padding(8.dp)) {
        Row(modifier = modifier.fillMaxWidth()) {
            Column(modifier = modifier
                .weight(1f)
                .padding(8.dp)) {
                Text(text = stringResource(id = R.string.bin) + ": " + bin.bin,
                    style = TextStyle(fontWeight = FontWeight.Bold))
                Text(text = stringResource(id = R.string.bank),
                    style = TextStyle(fontWeight = FontWeight.Bold))

                Text(text = bin.nameBank, maxLines = 1)

                Text(text = bin.urlBank,
                    maxLines = 1,
                    color = DeepBlue,
                    modifier = modifier.clickable {
                        if (bin.urlBank != "")
                            startActivity(ctx,
                                Intent(Intent.ACTION_VIEW, Uri.parse("https://" + bin.urlBank)),
                                null)
                    })

                Text(text = bin.phoneBank,
                    maxLines = 1,
                    color = DeepBlue,
                    modifier = modifier.clickable {
                        if (bin.phoneBank != "") {
                            val uri = Uri.parse("tel:" + bin.phoneBank)
                            val intent = Intent(Intent.ACTION_DIAL, uri)
                            try {
                                ctx.startActivity(intent)
                            } catch (s: SecurityException) {
                                Log.e("ERROR", "SecurityException: " + s.message)
                            }
                        }
                    })

                Spacer(modifier = modifier.height(16.dp))

                Text(text = stringResource(id = R.string.country),
                    style = TextStyle(fontWeight = FontWeight.Bold))

                Text(text = bin.country, maxLines = 1)
            }
            Column(modifier = modifier
                .weight(1f)
                .padding(8.dp)) {

                Text(text = stringResource(id = R.string.network),
                    style = TextStyle(fontWeight = FontWeight.Bold))

                Text(text = bin.scheme, maxLines = 1)

                Text(text = stringResource(id = R.string.brand),
                    style = TextStyle(fontWeight = FontWeight.Bold))

                Text(text = bin.brand, maxLines = 1)

                Text(text = stringResource(id = R.string.type),
                    style = TextStyle(fontWeight = FontWeight.Bold))

                Text(text = bin.type, maxLines = 1)

                Text(text = stringResource(id = R.string.prepaid),
                    style = TextStyle(fontWeight = FontWeight.Bold))

                Text(text = bin.prepaid.toString(), maxLines = 1)
            }
        }
    }
}

@Preview
@Composable
fun Show() {
    CardOfInfo(BinEntity())
}
