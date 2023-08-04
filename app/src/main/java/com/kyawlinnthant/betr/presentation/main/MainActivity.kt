package com.kyawlinnthant.betr.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.kyawlinnthant.betr.presentation.navigation.BetrGraph
import com.kyawlinnthant.betr.presentation.navigation.BottomBar
import com.kyawlinnthant.betr.presentation.theme.BetrTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BetrTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    Scaffold(
                        contentWindowInsets = WindowInsets(
                            left = 0,
                            top = 0,
                            right = 0,
                            bottom = 0,
                        ),
                        bottomBar = {
                            BottomBar(navController = navController)
                        },
                    ) {
                        BetrGraph(
                            paddingValues = it,
                            controller = navController,
                        )
                    }
                }
            }
        }
    }
}
