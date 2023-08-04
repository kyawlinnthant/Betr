package com.kyawlinnthant.betr.presentation.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(
    navController: NavHostController
) {
    val bars = setOf(
        Screen.Setting,
        Screen.Updates
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination

    NavigationBar {
        bars.forEach {
            BottomBarItem(
                screen = it,
                navController = navController,
                currentRoute = currentRoute
            )
        }
    }
}