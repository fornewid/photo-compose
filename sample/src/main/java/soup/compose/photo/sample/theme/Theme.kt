package soup.compose.photo.sample.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable

private val SystemDarkColorPalette = SystemMaterialTheme.darkColors()
private val SystemLightColorPalette = SystemMaterialTheme.lightColors()

@Composable
fun SampleTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) {
        SystemDarkColorPalette
    } else {
        SystemLightColorPalette
    }
    SystemMaterialTheme(
        colors = colors,
        content = content
    )
}
