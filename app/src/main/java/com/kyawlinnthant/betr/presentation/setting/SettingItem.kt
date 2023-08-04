package com.kyawlinnthant.betr.presentation.setting

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ListItem
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun SettingItem(
    modifier: Modifier = Modifier,
    headline: Int,
    supporting: Int,
    enabled: Boolean,
    onCheckedChanged: (Boolean) -> Unit,
) {
    ListItem(
        modifier = modifier.fillMaxWidth(),
        headlineContent = {
            Text(text = stringResource(id = headline))
        },
        supportingContent = {
            Text(text = stringResource(id = supporting))
        },
        trailingContent = {
            Switch(checked = enabled, onCheckedChange = onCheckedChanged)
        }
    )
}