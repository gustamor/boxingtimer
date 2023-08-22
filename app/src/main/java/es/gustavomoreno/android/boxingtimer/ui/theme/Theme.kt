package es.gustavomoreno.android.boxingtimer.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors

private val DarkColorPalette = darkColors(
    primary = white80,
    secondary = yellow80,
    secondaryVariant = yellowClear80,
    surface = black80,
    onSurface = yellow80,
    background = deepBlue80,
    onBackground = amber80
)

private val LightColorPalette = lightColors(
    primary = white80,
    secondary = yellow80,
    surface = black80,
    onSurface = yellow80,
    background = deepBlue80,
    onBackground = amber80

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun BoxingTimerTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shape,
        content = content
    )
}
