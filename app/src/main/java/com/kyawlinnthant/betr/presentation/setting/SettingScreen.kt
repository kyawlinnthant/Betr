package com.kyawlinnthant.betr.presentation.setting

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kyawlinnthant.betr.R

@Composable
fun SettingScreen(
    enabled: Boolean,
    onCheckedChanged: (Boolean) -> Unit,
) {
    Scaffold {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            item {
                SettingItem(
                    headline = R.string.updated_headline,
                    supporting = R.string.updated_support,
                    enabled = enabled,
                    onCheckedChanged = onCheckedChanged
                )
            }
        }
    }
}