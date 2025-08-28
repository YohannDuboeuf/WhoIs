package com.example.whois.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFF8AD4B5),
    primaryContainer = Color(0xFF00695C),
    secondary = Color(0xFFFF4081),

)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF8AD4B5),
    primaryContainer = Color(0xFF00695C),
    secondary = Color(0xFFFF4081),
)

@Composable
fun WhoIsTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors
    val typography = Typography()

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        content = content
    )
}
