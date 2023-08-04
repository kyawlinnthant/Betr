package com.kyawlinnthant.betr.presentation.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController

@Composable
fun RowScope.BottomBarItem(
    screen: Screen,
    navController: NavHostController,
    currentRoute: NavDestination?,
) {
    var selected by remember { mutableStateOf(screen) }
    NavigationBarItem(
        selected = currentRoute?.hierarchy?.any { it.route == screen.route } == true,
        onClick = {
            selected = screen
            navController.navigate(screen.route) {
                popUpTo(Screen.Setting.route)
                launchSingleTop = true
                restoreState = true
            }
        },
        icon = {
            Icon(
                painter = painterResource(id = screen.icon),
                contentDescription = null
            )
        },
        label = {
            Text(text = stringResource(id = screen.label))
        }
    )

}