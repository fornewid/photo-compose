/*
 * Copyright 2023 SOUP
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
