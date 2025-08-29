package com.example.whois.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.whois.R

// Définir la palette de couleurs
private val LightColors = lightColorScheme(
    primary = Color(0xFF8AD4B5),
    primaryContainer = Color(0xFF00695C),
    secondary = Color(0xFFFF4081)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF8AD4B5),
    primaryContainer = Color(0xFF00695C),
    secondary = Color(0xFFFF4081)
)

val popFontFamily = FontFamily(
    Font(R.font.poppins_regular)
)

val popTypography = Typography(
    headlineLarge = TextStyle(
        fontFamily = popFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = popFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = popFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = popFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = popFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    bodySmall = TextStyle(
        fontFamily = popFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)

@Composable
fun WhoIsTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = popTypography,
        content = content
    )
}
