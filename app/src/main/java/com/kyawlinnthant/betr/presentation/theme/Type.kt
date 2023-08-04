package com.kyawlinnthant.betr.presentation.theme


import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kyawlinnthant.betr.R

val fonts = FontFamily(
    Font(R.font.sans_semi_condensed_black, weight = FontWeight.Black),
    Font(R.font.sans_semi_condensed_medium, weight = FontWeight.Medium),
    Font(R.font.sans_semi_condensed_regular, weight = FontWeight.Normal),
    Font(R.font.sans_semi_condensed_thin, weight = FontWeight.Thin),
    Font(R.font.sans_semi_condensed_bold, weight = FontWeight.Bold),
    Font(R.font.sans_semi_condensed_light, weight = FontWeight.Light),
    Font(R.font.sans_semi_condensed_extra_light, weight = FontWeight.ExtraLight),
    Font(R.font.sans_semi_condensed_extra_bold, weight = FontWeight.ExtraBold),
    Font(R.font.sans_semi_condensed_semi_bold, weight = FontWeight.SemiBold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = fonts,
        lineHeight = 64.sp,
        fontSize = 57.sp
    ),
    displayMedium = TextStyle(
        fontFamily = fonts,
        lineHeight = 52.sp,
        fontSize = 45.sp
    ),
    displaySmall = TextStyle(
        fontFamily = fonts,
        lineHeight = 44.sp,
        fontSize = 36.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = fonts,
        lineHeight = 40.sp,
        fontSize = 32.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = fonts,
        lineHeight = 36.sp,
        fontSize = 28.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = fonts,
        lineHeight = 32.sp,
        fontSize = 24.sp
    ),
    titleLarge = TextStyle(
        fontFamily = fonts,
        lineHeight = 28.sp,
        fontSize = 22.sp
    ),
    titleMedium = TextStyle(
        fontFamily = fonts,
        lineHeight = 24.sp,
        fontSize = 16.sp
    ),
    titleSmall = TextStyle(
        fontFamily = fonts,
        lineHeight = 20.sp,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = fonts,
        lineHeight = 24.sp,
        fontSize = 16.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = fonts,
        lineHeight = 20.sp,
        fontSize = 14.sp
    ),
    bodySmall = TextStyle(
        fontFamily = fonts,
        lineHeight = 16.sp,
        fontSize = 12.sp
    ),
    labelLarge = TextStyle(
        fontFamily = fonts,
        lineHeight = 20.sp,
        fontSize = 14.sp
    ),
    labelMedium = TextStyle(
        fontFamily = fonts,
        lineHeight = 16.sp,
        fontSize = 12.sp
    ),
    labelSmall = TextStyle(
        fontFamily = fonts,
        lineHeight = 16.sp,
        fontSize = 11.sp
    )
)