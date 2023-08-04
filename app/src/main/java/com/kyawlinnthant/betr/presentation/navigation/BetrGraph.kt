package com.kyawlinnthant.betr.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kyawlinnthant.betr.presentation.setting.SettingScreen
import com.kyawlinnthant.betr.presentation.setting.SettingViewModel
import com.kyawlinnthant.betr.presentation.updates.UpdateScreen
import com.kyawlinnthant.betr.presentation.updates.UpdateViewModel

@Composable
fun BetrGraph(
    controller: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = controller,
        startDestination = Screen.Setting.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(
            route = Screen.Setting.route
        ) {
            val vm : SettingViewModel = hiltViewModel()
            val enabled = vm.enabled.collectAsState()
            SettingScreen(
                enabled = enabled.value,
                onCheckedChanged = vm::setEnabled
            )
        }
        composable(
            route = Screen.Updates.route
        ) {
            val vm : UpdateViewModel = hiltViewModel()
            val apps = vm.apps.collectAsState()
            val enabled = vm.enabled.collectAsState()
            UpdateScreen(
                apps = apps.value,
                enabled = enabled.value
            )
        }
    }
}