package com.bolhy91.recyclerapp.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bolhy91.recyclerapp.R

@Composable
fun SettingScreen() {
    Column(
        modifier = Modifier.padding(
            start = 15.dp, top = 25.dp, end = 15.dp
        )
    ) {
        Row {
            Text(text = "Iniciar sesión", style = MaterialTheme.typography.h3)
            Icon(painter = painterResource(id = R.drawable.ic_google), contentDescription = null)
        }
    }
}