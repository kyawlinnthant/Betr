package com.kyawlinnthant.betr.presentation.navigation

import com.kyawlinnthant.betr.R


sealed class Screen(
    val route: String,
    val label: Int,
    val icon: Int
) {
    object Updates : Screen(
        route = "updates",
        label = R.string.update,
        icon = R.drawable.updates
    )

    object Setting : Screen(
        route = "setting",
        label = R.string.setting,
        icon = R.drawable.setting
    )
}
