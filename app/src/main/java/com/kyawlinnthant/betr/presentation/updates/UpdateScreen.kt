package com.kyawlinnthant.betr.presentation.updates

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.kyawlinnthant.betr.R
import com.kyawlinnthant.betr.data.UpdatedApp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateScreen(
    apps: List<UpdatedApp>,
    enabled: Boolean
) {
    val listState = rememberLazyListState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.updated_headline))
                },
                actions = {
                    IconButton(onClick = {  }) {
                        Icon(painter = painterResource(id = R.drawable.baseline_list_24), contentDescription = null )
                    }
                }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            state = listState
        ) {
            items(items = apps) { item ->
                UpdatedAppItem(icon = item.icon, name = item.name, enabled = enabled)
            }
        }
    }
}