package soup.compose.photo.sample.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun SystemMaterialTheme(
    colors: Colors = SystemMaterialTheme.lightColors(),
    typography: Typography = MaterialTheme.typography,
    shapes: Shapes = MaterialTheme.shapes,
    content: @Composable () -> Unit
) {
    MaterialTheme(colors, typography, shapes, content)
}

object SystemMaterialTheme {

    fun lightColors(
        primary: Color = Color(0xfff5f5f5),
        primaryVariant: Color = Color(0xFF757575),
        secondary: Color = Color(0xFF008577),
        secondaryVariant: Color = secondary,
        background: Color = Color(0xFFFAFAFA),
        surface: Color = background,
        error: Color = Color(0xFFFF5722),
        onPrimary: Color = Color.Black,
        onSecondary: Color = Color.Black,
        onBackground: Color = Color.Black,
        onSurface: Color = onBackground,
        onError: Color = Color.White
    ): Colors = Colors(
        primary,
        primaryVariant,
        secondary,
        secondaryVariant,
        background,
        surface,
        error,
        onPrimary,
        onSecondary,
        onBackground,
        onSurface,
        onError,
        true
    )

    fun darkColors(
        primary: Color = Color(0xFF212121),
        primaryVariant: Color = Color.Black,
        secondary: Color = Color(0xFF80CBC4),
        secondaryVariant: Color = secondary,
        background: Color = Color(0xFF303030),
        surface: Color = background,
        error: Color = Color(0xFFFF7043),
        onPrimary: Color = Color.Black,
        onSecondary: Color = Color.Black,
        onBackground: Color = Color.White,
        onSurface: Color = onBackground,
        onError: Color = Color.Black
    ): Colors = Colors(
        primary,
        primaryVariant,
        secondary,
        secondaryVariant,
        background,
        surface,
        error,
        onPrimary,
        onSecondary,
        onBackground,
        onSurface,
        onError,
        false
    )
}
