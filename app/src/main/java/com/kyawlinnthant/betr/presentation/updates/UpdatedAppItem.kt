package com.kyawlinnthant.betr.presentation.updates

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import kotlin.random.Random

@Composable
fun UpdatedAppItem(
    modifier: Modifier = Modifier,
    icon: Int,
    name: Int,
    enabled: Boolean
) {
    val color = if (enabled) randomColor() else Color.Gray
    ListItem(
        modifier = modifier.fillMaxWidth(),
        leadingContent = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = Color.Unspecified
            )
        },
        headlineContent = {
            Text(text = stringResource(id = name), color = color)
        }
    )
}

fun randomColor(): Color {
    val random = Random.Default
    return Color(
        red = random.nextFloat(),
        green = random.nextFloat(),
        blue = random.nextFloat(),
    )
}