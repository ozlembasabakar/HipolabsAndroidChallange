package com.example.hipolabschallange.designsystem.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    surface = Color.Black,
    onSurface = Color.White,
    primaryContainer = SearchBarBackground,
    onPrimaryContainer = Color.Black,
    secondaryContainer = CardBackground,
    onSecondaryContainer = Color.Black,
    tertiaryContainer = ButtonBackground,
    onTertiaryContainer = Color.Black,
    primary = DialogInputFieldBackground,
    onPrimary = Color.Black
)

private val LightColorScheme = lightColorScheme(
    surface = Color.White,
    onSurface = Color.Black,
    primaryContainer = SearchBarBackground,
    onPrimaryContainer = Color.Black,
    secondaryContainer = CardBackground,
    onSecondaryContainer = CardInputText,
    tertiaryContainer = ButtonBackground,
    onTertiaryContainer = Color.White,
    primary = DialogInputFieldBackground,
    onPrimary = Color.Black
)

@Composable
fun HipolabsChallengeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        val currentWindow = (view.context as? Activity)?.window
            ?: throw Exception("Not in an activity - unable to get Window reference")
        SideEffect {
            currentWindow.statusBarColor = colorScheme.surface.toArgb()
            WindowCompat.getInsetsController(currentWindow, view).isAppearanceLightStatusBars =
                darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}