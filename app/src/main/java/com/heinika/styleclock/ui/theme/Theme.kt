@file:Suppress("DEPRECATION")

package com.heinika.styleclock.ui.theme

import android.app.Activity
import android.content.Context
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import com.heinika.styleclock.R

private val LightColors = lightColorScheme(
  primary = md_theme_light_primary,
  onPrimary = md_theme_light_onPrimary,
  primaryContainer = md_theme_light_primaryContainer,
  onPrimaryContainer = md_theme_light_onPrimaryContainer,
  secondary = md_theme_light_secondary,
  onSecondary = md_theme_light_onSecondary,
  secondaryContainer = md_theme_light_secondaryContainer,
  onSecondaryContainer = md_theme_light_onSecondaryContainer,
  tertiary = md_theme_light_tertiary,
  onTertiary = md_theme_light_onTertiary,
  tertiaryContainer = md_theme_light_tertiaryContainer,
  onTertiaryContainer = md_theme_light_onTertiaryContainer,
  error = md_theme_light_error,
  errorContainer = md_theme_light_errorContainer,
  onError = md_theme_light_onError,
  onErrorContainer = md_theme_light_onErrorContainer,
  background = md_theme_light_background,
  onBackground = md_theme_light_onBackground,
  surface = md_theme_light_surface,
  onSurface = md_theme_light_onSurface,
  surfaceVariant = md_theme_light_surfaceVariant,
  onSurfaceVariant = md_theme_light_onSurfaceVariant,
  outline = md_theme_light_outline,
  inverseOnSurface = md_theme_light_inverseOnSurface,
  inverseSurface = md_theme_light_inverseSurface,
  inversePrimary = md_theme_light_inversePrimary,
  surfaceTint = md_theme_light_surfaceTint
)


private val DarkColors = darkColorScheme(
  primary = md_theme_dark_primary,
  onPrimary = md_theme_dark_onPrimary,
  primaryContainer = md_theme_dark_primaryContainer,
  onPrimaryContainer = md_theme_dark_onPrimaryContainer,
  secondary = md_theme_dark_secondary,
  onSecondary = md_theme_dark_onSecondary,
  secondaryContainer = md_theme_dark_secondaryContainer,
  onSecondaryContainer = md_theme_dark_onSecondaryContainer,
  tertiary = md_theme_dark_tertiary,
  onTertiary = md_theme_dark_onTertiary,
  tertiaryContainer = md_theme_dark_tertiaryContainer,
  onTertiaryContainer = md_theme_dark_onTertiaryContainer,
  error = md_theme_dark_error,
  errorContainer = md_theme_dark_errorContainer,
  onError = md_theme_dark_onError,
  onErrorContainer = md_theme_dark_onErrorContainer,
  background = md_theme_dark_background,
  onBackground = md_theme_dark_onBackground,
  surface = md_theme_dark_surface,
  onSurface = md_theme_dark_onSurface,
  surfaceVariant = md_theme_dark_surfaceVariant,
  onSurfaceVariant = md_theme_dark_onSurfaceVariant,
  outline = md_theme_dark_outline,
  inverseOnSurface = md_theme_dark_inverseOnSurface,
  inverseSurface = md_theme_dark_inverseSurface,
  inversePrimary = md_theme_dark_inversePrimary,
  surfaceTint = md_theme_dark_surfaceTint
)

private val LightGreenColors = lightColorScheme(
  primary = md_theme_light_green_primary,
  onPrimary = md_theme_light_green_onPrimary,
  primaryContainer = md_theme_light_green_primaryContainer,
  onPrimaryContainer = md_theme_light_green_onPrimaryContainer,
  secondary = md_theme_light_green_secondary,
  onSecondary = md_theme_light_green_onSecondary,
  secondaryContainer = md_theme_light_green_secondaryContainer,
  onSecondaryContainer = md_theme_light_green_onSecondaryContainer,
  tertiary = md_theme_light_green_tertiary,
  onTertiary = md_theme_light_green_onTertiary,
  tertiaryContainer = md_theme_light_green_tertiaryContainer,
  onTertiaryContainer = md_theme_light_green_onTertiaryContainer,
  error = md_theme_light_green_error,
  errorContainer = md_theme_light_green_errorContainer,
  onError = md_theme_light_green_onError,
  onErrorContainer = md_theme_light_green_onErrorContainer,
  background = md_theme_light_green_background,
  onBackground = md_theme_light_green_onBackground,
  surface = md_theme_light_green_surface,
  onSurface = md_theme_light_green_onSurface,
  surfaceVariant = md_theme_light_green_surfaceVariant,
  onSurfaceVariant = md_theme_light_green_onSurfaceVariant,
  outline = md_theme_light_green_outline,
  inverseOnSurface = md_theme_light_green_inverseOnSurface,
  inverseSurface = md_theme_light_green_inverseSurface,
  inversePrimary = md_theme_light_green_inversePrimary,
  surfaceTint = md_theme_light_green_surfaceTint
)


private val DarkGreenColors = darkColorScheme(
  primary = md_theme_dark_green_primary,
  onPrimary = md_theme_dark_green_onPrimary,
  primaryContainer = md_theme_dark_green_primaryContainer,
  onPrimaryContainer = md_theme_dark_green_onPrimaryContainer,
  secondary = md_theme_dark_green_secondary,
  onSecondary = md_theme_dark_green_onSecondary,
  secondaryContainer = md_theme_dark_green_secondaryContainer,
  onSecondaryContainer = md_theme_dark_green_onSecondaryContainer,
  tertiary = md_theme_dark_green_tertiary,
  onTertiary = md_theme_dark_green_onTertiary,
  tertiaryContainer = md_theme_dark_green_tertiaryContainer,
  onTertiaryContainer = md_theme_dark_green_onTertiaryContainer,
  error = md_theme_dark_green_error,
  errorContainer = md_theme_dark_green_errorContainer,
  onError = md_theme_dark_green_onError,
  onErrorContainer = md_theme_dark_green_onErrorContainer,
  background = md_theme_dark_green_background,
  onBackground = md_theme_dark_green_onBackground,
  surface = md_theme_dark_green_surface,
  onSurface = md_theme_dark_green_onSurface,
  surfaceVariant = md_theme_dark_green_surfaceVariant,
  onSurfaceVariant = md_theme_dark_green_onSurfaceVariant,
  outline = md_theme_dark_green_outline,
  inverseOnSurface = md_theme_dark_green_inverseOnSurface,
  inverseSurface = md_theme_dark_green_inverseSurface,
  inversePrimary = md_theme_dark_green_inversePrimary,
  surfaceTint = md_theme_dark_green_surfaceTint
)

private val LightBlueColors = lightColorScheme(
  primary = md_theme_light_blue_primary,
  onPrimary = md_theme_light_blue_onPrimary,
  primaryContainer = md_theme_light_blue_primaryContainer,
  onPrimaryContainer = md_theme_light_blue_onPrimaryContainer,
  secondary = md_theme_light_blue_secondary,
  onSecondary = md_theme_light_blue_onSecondary,
  secondaryContainer = md_theme_light_blue_secondaryContainer,
  onSecondaryContainer = md_theme_light_blue_onSecondaryContainer,
  tertiary = md_theme_light_blue_tertiary,
  onTertiary = md_theme_light_blue_onTertiary,
  tertiaryContainer = md_theme_light_blue_tertiaryContainer,
  onTertiaryContainer = md_theme_light_blue_onTertiaryContainer,
  error = md_theme_light_blue_error,
  errorContainer = md_theme_light_blue_errorContainer,
  onError = md_theme_light_blue_onError,
  onErrorContainer = md_theme_light_blue_onErrorContainer,
  background = md_theme_light_blue_background,
  onBackground = md_theme_light_blue_onBackground,
  surface = md_theme_light_blue_surface,
  onSurface = md_theme_light_blue_onSurface,
  surfaceVariant = md_theme_light_blue_surfaceVariant,
  onSurfaceVariant = md_theme_light_blue_onSurfaceVariant,
  outline = md_theme_light_blue_outline,
  inverseOnSurface = md_theme_light_blue_inverseOnSurface,
  inverseSurface = md_theme_light_blue_inverseSurface,
  inversePrimary = md_theme_light_blue_inversePrimary,
  surfaceTint = md_theme_light_blue_surfaceTint
)


private val DarkBlueColors = darkColorScheme(
  primary = md_theme_dark_blue_primary,
  onPrimary = md_theme_dark_blue_onPrimary,
  primaryContainer = md_theme_dark_blue_primaryContainer,
  onPrimaryContainer = md_theme_dark_blue_onPrimaryContainer,
  secondary = md_theme_dark_blue_secondary,
  onSecondary = md_theme_dark_blue_onSecondary,
  secondaryContainer = md_theme_dark_blue_secondaryContainer,
  onSecondaryContainer = md_theme_dark_blue_onSecondaryContainer,
  tertiary = md_theme_dark_blue_tertiary,
  onTertiary = md_theme_dark_blue_onTertiary,
  tertiaryContainer = md_theme_dark_blue_tertiaryContainer,
  onTertiaryContainer = md_theme_dark_blue_onTertiaryContainer,
  error = md_theme_dark_blue_error,
  errorContainer = md_theme_dark_blue_errorContainer,
  onError = md_theme_dark_blue_onError,
  onErrorContainer = md_theme_dark_blue_onErrorContainer,
  background = md_theme_dark_blue_background,
  onBackground = md_theme_dark_blue_onBackground,
  surface = md_theme_dark_blue_surface,
  onSurface = md_theme_dark_blue_onSurface,
  surfaceVariant = md_theme_dark_blue_surfaceVariant,
  onSurfaceVariant = md_theme_dark_blue_onSurfaceVariant,
  outline = md_theme_dark_blue_outline,
  inverseOnSurface = md_theme_dark_blue_inverseOnSurface,
  inverseSurface = md_theme_dark_blue_inverseSurface,
  inversePrimary = md_theme_dark_blue_inversePrimary,
  surfaceTint = md_theme_dark_blue_surfaceTint
)

private val LightPurpleColors = lightColorScheme(
  primary = md_theme_light_purple_primary,
  onPrimary = md_theme_light_purple_onPrimary,
  primaryContainer = md_theme_light_purple_primaryContainer,
  onPrimaryContainer = md_theme_light_purple_onPrimaryContainer,
  secondary = md_theme_light_purple_secondary,
  onSecondary = md_theme_light_purple_onSecondary,
  secondaryContainer = md_theme_light_purple_secondaryContainer,
  onSecondaryContainer = md_theme_light_purple_onSecondaryContainer,
  tertiary = md_theme_light_purple_tertiary,
  onTertiary = md_theme_light_purple_onTertiary,
  tertiaryContainer = md_theme_light_purple_tertiaryContainer,
  onTertiaryContainer = md_theme_light_purple_onTertiaryContainer,
  error = md_theme_light_purple_error,
  errorContainer = md_theme_light_purple_errorContainer,
  onError = md_theme_light_purple_onError,
  onErrorContainer = md_theme_light_purple_onErrorContainer,
  background = md_theme_light_purple_background,
  onBackground = md_theme_light_purple_onBackground,
  surface = md_theme_light_purple_surface,
  onSurface = md_theme_light_purple_onSurface,
  surfaceVariant = md_theme_light_purple_surfaceVariant,
  onSurfaceVariant = md_theme_light_purple_onSurfaceVariant,
  outline = md_theme_light_purple_outline,
  inverseOnSurface = md_theme_light_purple_inverseOnSurface,
  inverseSurface = md_theme_light_purple_inverseSurface,
  inversePrimary = md_theme_light_purple_inversePrimary,
  surfaceTint = md_theme_light_purple_surfaceTint
)


private val DarkPurpleColors = darkColorScheme(
  primary = md_theme_dark_purple_primary,
  onPrimary = md_theme_dark_purple_onPrimary,
  primaryContainer = md_theme_dark_purple_primaryContainer,
  onPrimaryContainer = md_theme_dark_purple_onPrimaryContainer,
  secondary = md_theme_dark_purple_secondary,
  onSecondary = md_theme_dark_purple_onSecondary,
  secondaryContainer = md_theme_dark_purple_secondaryContainer,
  onSecondaryContainer = md_theme_dark_purple_onSecondaryContainer,
  tertiary = md_theme_dark_purple_tertiary,
  onTertiary = md_theme_dark_purple_onTertiary,
  tertiaryContainer = md_theme_dark_purple_tertiaryContainer,
  onTertiaryContainer = md_theme_dark_purple_onTertiaryContainer,
  error = md_theme_dark_purple_error,
  errorContainer = md_theme_dark_purple_errorContainer,
  onError = md_theme_dark_purple_onError,
  onErrorContainer = md_theme_dark_purple_onErrorContainer,
  background = md_theme_dark_purple_background,
  onBackground = md_theme_dark_purple_onBackground,
  surface = md_theme_dark_purple_surface,
  onSurface = md_theme_dark_purple_onSurface,
  surfaceVariant = md_theme_dark_purple_surfaceVariant,
  onSurfaceVariant = md_theme_dark_purple_onSurfaceVariant,
  outline = md_theme_dark_purple_outline,
  inverseOnSurface = md_theme_dark_purple_inverseOnSurface,
  inverseSurface = md_theme_dark_purple_inverseSurface,
  inversePrimary = md_theme_dark_purple_inversePrimary,
  surfaceTint = md_theme_dark_purple_surfaceTint
)

private val LightColorful1Colors = lightColorScheme(
  primary = md_theme_light_colorful1_primary,
  onPrimary = md_theme_light_colorful1_onPrimary,
  primaryContainer = md_theme_light_colorful1_primaryContainer,
  onPrimaryContainer = md_theme_light_colorful1_onPrimaryContainer,
  secondary = md_theme_light_colorful1_secondary,
  onSecondary = md_theme_light_colorful1_onSecondary,
  secondaryContainer = md_theme_light_colorful1_secondaryContainer,
  onSecondaryContainer = md_theme_light_colorful1_onSecondaryContainer,
  tertiary = md_theme_light_colorful1_tertiary,
  onTertiary = md_theme_light_colorful1_onTertiary,
  tertiaryContainer = md_theme_light_colorful1_tertiaryContainer,
  onTertiaryContainer = md_theme_light_colorful1_onTertiaryContainer,
  error = md_theme_light_colorful1_error,
  errorContainer = md_theme_light_colorful1_errorContainer,
  onError = md_theme_light_colorful1_onError,
  onErrorContainer = md_theme_light_colorful1_onErrorContainer,
  background = md_theme_light_colorful1_background,
  onBackground = md_theme_light_colorful1_onBackground,
  surface = md_theme_light_colorful1_surface,
  onSurface = md_theme_light_colorful1_onSurface,
  surfaceVariant = md_theme_light_colorful1_surfaceVariant,
  onSurfaceVariant = md_theme_light_colorful1_onSurfaceVariant,
  outline = md_theme_light_colorful1_outline,
  inverseOnSurface = md_theme_light_colorful1_inverseOnSurface,
  inverseSurface = md_theme_light_colorful1_inverseSurface,
  inversePrimary = md_theme_light_colorful1_inversePrimary,
  surfaceTint = md_theme_light_colorful1_surfaceTint
)


private val DarkColorful1Colors = darkColorScheme(
  primary = md_theme_dark_colorful1_primary,
  onPrimary = md_theme_dark_colorful1_onPrimary,
  primaryContainer = md_theme_dark_colorful1_primaryContainer,
  onPrimaryContainer = md_theme_dark_colorful1_onPrimaryContainer,
  secondary = md_theme_dark_colorful1_secondary,
  onSecondary = md_theme_dark_colorful1_onSecondary,
  secondaryContainer = md_theme_dark_colorful1_secondaryContainer,
  onSecondaryContainer = md_theme_dark_colorful1_onSecondaryContainer,
  tertiary = md_theme_dark_colorful1_tertiary,
  onTertiary = md_theme_dark_colorful1_onTertiary,
  tertiaryContainer = md_theme_dark_colorful1_tertiaryContainer,
  onTertiaryContainer = md_theme_dark_colorful1_onTertiaryContainer,
  error = md_theme_dark_colorful1_error,
  errorContainer = md_theme_dark_colorful1_errorContainer,
  onError = md_theme_dark_colorful1_onError,
  onErrorContainer = md_theme_dark_colorful1_onErrorContainer,
  background = md_theme_dark_colorful1_background,
  onBackground = md_theme_dark_colorful1_onBackground,
  surface = md_theme_dark_colorful1_surface,
  onSurface = md_theme_dark_colorful1_onSurface,
  surfaceVariant = md_theme_dark_colorful1_surfaceVariant,
  onSurfaceVariant = md_theme_dark_colorful1_onSurfaceVariant,
  outline = md_theme_dark_colorful1_outline,
  inverseOnSurface = md_theme_dark_colorful1_inverseOnSurface,
  inverseSurface = md_theme_dark_colorful1_inverseSurface,
  inversePrimary = md_theme_dark_colorful1_inversePrimary,
  surfaceTint = md_theme_dark_colorful1_surfaceTint
)

private val LightColorful2Colors = lightColorScheme(
  primary = md_theme_light_colorful2_primary,
  onPrimary = md_theme_light_colorful2_onPrimary,
  primaryContainer = md_theme_light_colorful2_primaryContainer,
  onPrimaryContainer = md_theme_light_colorful2_onPrimaryContainer,
  secondary = md_theme_light_colorful2_secondary,
  onSecondary = md_theme_light_colorful2_onSecondary,
  secondaryContainer = md_theme_light_colorful2_secondaryContainer,
  onSecondaryContainer = md_theme_light_colorful2_onSecondaryContainer,
  tertiary = md_theme_light_colorful2_tertiary,
  onTertiary = md_theme_light_colorful2_onTertiary,
  tertiaryContainer = md_theme_light_colorful2_tertiaryContainer,
  onTertiaryContainer = md_theme_light_colorful2_onTertiaryContainer,
  error = md_theme_light_colorful2_error,
  errorContainer = md_theme_light_colorful2_errorContainer,
  onError = md_theme_light_colorful2_onError,
  onErrorContainer = md_theme_light_colorful2_onErrorContainer,
  background = md_theme_light_colorful2_background,
  onBackground = md_theme_light_colorful2_onBackground,
  surface = md_theme_light_colorful2_surface,
  onSurface = md_theme_light_colorful2_onSurface,
  surfaceVariant = md_theme_light_colorful2_surfaceVariant,
  onSurfaceVariant = md_theme_light_colorful2_onSurfaceVariant,
  outline = md_theme_light_colorful2_outline,
  inverseOnSurface = md_theme_light_colorful2_inverseOnSurface,
  inverseSurface = md_theme_light_colorful2_inverseSurface,
  inversePrimary = md_theme_light_colorful2_inversePrimary,
  surfaceTint = md_theme_light_colorful2_surfaceTint
)


private val DarkColorful2Colors = darkColorScheme(
  primary = md_theme_dark_colorful2_primary,
  onPrimary = md_theme_dark_colorful2_onPrimary,
  primaryContainer = md_theme_dark_colorful2_primaryContainer,
  onPrimaryContainer = md_theme_dark_colorful2_onPrimaryContainer,
  secondary = md_theme_dark_colorful2_secondary,
  onSecondary = md_theme_dark_colorful2_onSecondary,
  secondaryContainer = md_theme_dark_colorful2_secondaryContainer,
  onSecondaryContainer = md_theme_dark_colorful2_onSecondaryContainer,
  tertiary = md_theme_dark_colorful2_tertiary,
  onTertiary = md_theme_dark_colorful2_onTertiary,
  tertiaryContainer = md_theme_dark_colorful2_tertiaryContainer,
  onTertiaryContainer = md_theme_dark_colorful2_onTertiaryContainer,
  error = md_theme_dark_colorful2_error,
  errorContainer = md_theme_dark_colorful2_errorContainer,
  onError = md_theme_dark_colorful2_onError,
  onErrorContainer = md_theme_dark_colorful2_onErrorContainer,
  background = md_theme_dark_colorful2_background,
  onBackground = md_theme_dark_colorful2_onBackground,
  surface = md_theme_dark_colorful2_surface,
  onSurface = md_theme_dark_colorful2_onSurface,
  surfaceVariant = md_theme_dark_colorful2_surfaceVariant,
  onSurfaceVariant = md_theme_dark_colorful2_onSurfaceVariant,
  outline = md_theme_dark_colorful2_outline,
  inverseOnSurface = md_theme_dark_colorful2_inverseOnSurface,
  inverseSurface = md_theme_dark_colorful2_inverseSurface,
  inversePrimary = md_theme_dark_colorful2_inversePrimary,
  surfaceTint = md_theme_dark_colorful2_surfaceTint
)

private val LightPinkColors = lightColorScheme(
  primary = md_theme_light_pink_primary,
  onPrimary = md_theme_light_pink_onPrimary,
  primaryContainer = md_theme_light_pink_primaryContainer,
  onPrimaryContainer = md_theme_light_pink_onPrimaryContainer,
  secondary = md_theme_light_pink_secondary,
  onSecondary = md_theme_light_pink_onSecondary,
  secondaryContainer = md_theme_light_pink_secondaryContainer,
  onSecondaryContainer = md_theme_light_pink_onSecondaryContainer,
  tertiary = md_theme_light_pink_tertiary,
  onTertiary = md_theme_light_pink_onTertiary,
  tertiaryContainer = md_theme_light_pink_tertiaryContainer,
  onTertiaryContainer = md_theme_light_pink_onTertiaryContainer,
  error = md_theme_light_pink_error,
  errorContainer = md_theme_light_pink_errorContainer,
  onError = md_theme_light_pink_onError,
  onErrorContainer = md_theme_light_pink_onErrorContainer,
  background = md_theme_light_pink_background,
  onBackground = md_theme_light_pink_onBackground,
  surface = md_theme_light_pink_surface,
  onSurface = md_theme_light_pink_onSurface,
  surfaceVariant = md_theme_light_pink_surfaceVariant,
  onSurfaceVariant = md_theme_light_pink_onSurfaceVariant,
  outline = md_theme_light_pink_outline,
  inverseOnSurface = md_theme_light_pink_inverseOnSurface,
  inverseSurface = md_theme_light_pink_inverseSurface,
  inversePrimary = md_theme_light_pink_inversePrimary,
  surfaceTint = md_theme_light_pink_surfaceTint
)


private val DarkPinkColors = darkColorScheme(
  primary = md_theme_dark_pink_primary,
  onPrimary = md_theme_dark_pink_onPrimary,
  primaryContainer = md_theme_dark_pink_primaryContainer,
  onPrimaryContainer = md_theme_dark_pink_onPrimaryContainer,
  secondary = md_theme_dark_pink_secondary,
  onSecondary = md_theme_dark_pink_onSecondary,
  secondaryContainer = md_theme_dark_pink_secondaryContainer,
  onSecondaryContainer = md_theme_dark_pink_onSecondaryContainer,
  tertiary = md_theme_dark_pink_tertiary,
  onTertiary = md_theme_dark_pink_onTertiary,
  tertiaryContainer = md_theme_dark_pink_tertiaryContainer,
  onTertiaryContainer = md_theme_dark_pink_onTertiaryContainer,
  error = md_theme_dark_pink_error,
  errorContainer = md_theme_dark_pink_errorContainer,
  onError = md_theme_dark_pink_onError,
  onErrorContainer = md_theme_dark_pink_onErrorContainer,
  background = md_theme_dark_pink_background,
  onBackground = md_theme_dark_pink_onBackground,
  surface = md_theme_dark_pink_surface,
  onSurface = md_theme_dark_pink_onSurface,
  surfaceVariant = md_theme_dark_pink_surfaceVariant,
  onSurfaceVariant = md_theme_dark_pink_onSurfaceVariant,
  outline = md_theme_dark_pink_outline,
  inverseOnSurface = md_theme_dark_pink_inverseOnSurface,
  inverseSurface = md_theme_dark_pink_inverseSurface,
  inversePrimary = md_theme_dark_pink_inversePrimary,
  surfaceTint = md_theme_dark_pink_surfaceTint
)


private val LightOrangeColors = lightColorScheme(
  primary = md_theme_light_orange_primary,
  onPrimary = md_theme_light_orange_onPrimary,
  primaryContainer = md_theme_light_orange_primaryContainer,
  onPrimaryContainer = md_theme_light_orange_onPrimaryContainer,
  secondary = md_theme_light_orange_secondary,
  onSecondary = md_theme_light_orange_onSecondary,
  secondaryContainer = md_theme_light_orange_secondaryContainer,
  onSecondaryContainer = md_theme_light_orange_onSecondaryContainer,
  tertiary = md_theme_light_orange_tertiary,
  onTertiary = md_theme_light_orange_onTertiary,
  tertiaryContainer = md_theme_light_orange_tertiaryContainer,
  onTertiaryContainer = md_theme_light_orange_onTertiaryContainer,
  error = md_theme_light_orange_error,
  errorContainer = md_theme_light_orange_errorContainer,
  onError = md_theme_light_orange_onError,
  onErrorContainer = md_theme_light_orange_onErrorContainer,
  background = md_theme_light_orange_background,
  onBackground = md_theme_light_orange_onBackground,
  surface = md_theme_light_orange_surface,
  onSurface = md_theme_light_orange_onSurface,
  surfaceVariant = md_theme_light_orange_surfaceVariant,
  onSurfaceVariant = md_theme_light_orange_onSurfaceVariant,
  outline = md_theme_light_orange_outline,
  inverseOnSurface = md_theme_light_orange_inverseOnSurface,
  inverseSurface = md_theme_light_orange_inverseSurface,
  inversePrimary = md_theme_light_orange_inversePrimary,
  surfaceTint = md_theme_light_orange_surfaceTint
)


private val DarkOrangeColors = darkColorScheme(
  primary = md_theme_dark_orange_primary,
  onPrimary = md_theme_dark_orange_onPrimary,
  primaryContainer = md_theme_dark_orange_primaryContainer,
  onPrimaryContainer = md_theme_dark_orange_onPrimaryContainer,
  secondary = md_theme_dark_orange_secondary,
  onSecondary = md_theme_dark_orange_onSecondary,
  secondaryContainer = md_theme_dark_orange_secondaryContainer,
  onSecondaryContainer = md_theme_dark_orange_onSecondaryContainer,
  tertiary = md_theme_dark_orange_tertiary,
  onTertiary = md_theme_dark_orange_onTertiary,
  tertiaryContainer = md_theme_dark_orange_tertiaryContainer,
  onTertiaryContainer = md_theme_dark_orange_onTertiaryContainer,
  error = md_theme_dark_orange_error,
  errorContainer = md_theme_dark_orange_errorContainer,
  onError = md_theme_dark_orange_onError,
  onErrorContainer = md_theme_dark_orange_onErrorContainer,
  background = md_theme_dark_orange_background,
  onBackground = md_theme_dark_orange_onBackground,
  surface = md_theme_dark_orange_surface,
  onSurface = md_theme_dark_orange_onSurface,
  surfaceVariant = md_theme_dark_orange_surfaceVariant,
  onSurfaceVariant = md_theme_dark_orange_onSurfaceVariant,
  outline = md_theme_dark_orange_outline,
  inverseOnSurface = md_theme_dark_orange_inverseOnSurface,
  inverseSurface = md_theme_dark_orange_inverseSurface,
  inversePrimary = md_theme_dark_orange_inversePrimary,
  surfaceTint = md_theme_dark_orange_surfaceTint
)

enum class Theme {
  DynamicTheme,
  DynamicLightTheme,
  DynamicDarkTheme,
  AutoTheme,
  LightTheme,
  DarkTheme,
  LightGreenTheme,
  DarkGreenTheme,
  LightBlueTheme,
  DarkBlueTheme,
  LightPinkTheme,
  DarkPinkTheme,
  LightOrangeTheme,
  DarkOrangeTheme,
  LightColorful2Theme,
  DarkColorful12heme,
  LightColorful1Theme,
  DarkColorful1Theme,
  LightPurpleTheme,
  DarkPurpleTheme;

  fun getColorScheme(darkTheme: Boolean, context: Context): ColorScheme = when (this) {
    DynamicTheme -> {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      } else {
        if (darkTheme) DarkColors else LightColors
      }
    }
    AutoTheme -> {
      if (darkTheme) DarkColors else LightColors
    }
    LightTheme -> LightColors
    DarkTheme -> DarkColors
    LightGreenTheme -> LightGreenColors
    DarkGreenTheme -> DarkGreenColors
    LightBlueTheme -> LightBlueColors
    DarkBlueTheme -> DarkBlueColors
    DynamicLightTheme -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
      dynamicLightColorScheme(context)
    } else {
      LightColors
    }
    DynamicDarkTheme -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
      dynamicDarkColorScheme(context)
    } else {
      DarkColors
    }
    LightPurpleTheme -> LightPurpleColors
    DarkPurpleTheme -> DarkPurpleColors
    LightColorful1Theme -> LightColorful1Colors
    DarkColorful1Theme -> DarkColorful1Colors
    LightColorful2Theme -> LightColorful2Colors
    DarkColorful12heme -> DarkColorful2Colors
    LightPinkTheme -> LightPinkColors
    DarkPinkTheme -> DarkPinkColors
    LightOrangeTheme -> LightOrangeColors
    DarkOrangeTheme -> DarkOrangeColors
  }


  fun getTextId(): Int = when (this) {
    DynamicTheme -> R.string.system_theme
    AutoTheme -> R.string.auto_theme
    LightTheme -> R.string.light_theme
    DarkTheme -> R.string.dark_theme
    DynamicLightTheme -> R.string.dynamic_light_theme
    DynamicDarkTheme -> R.string.dynamic_dark_theme
    LightGreenTheme -> R.string.light_green_theme
    DarkGreenTheme -> R.string.dark_green_theme
    LightBlueTheme -> R.string.light_blue_theme
    DarkBlueTheme -> R.string.dark_blue_theme
    LightPurpleTheme -> R.string.light_purple_theme
    DarkPurpleTheme -> R.string.dark_purple_theme
    LightColorful1Theme -> R.string.light_colorful_theme
    DarkColorful1Theme -> R.string.dark_colorful_theme
    LightColorful2Theme -> R.string.light_colorful_theme
    DarkColorful12heme -> R.string.dark_colorful_theme
    LightPinkTheme -> R.string.light_pink_theme
    DarkPinkTheme -> R.string.dark_pink_theme
    LightOrangeTheme -> R.string.light_orange_theme
    DarkOrangeTheme -> R.string.dark_orange_theme
  }

}

fun getThemesBaseSdk(): List<Theme> {
  return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
    Theme.values().toList()
  }else{
    Theme.values().toList().filter { !it.name.contains("Dynamic")  }
  }
}

@Composable
fun PureClockTheme(
  theme: Theme = Theme.DynamicTheme,
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit
) {
  val colorScheme = theme.getColorScheme(darkTheme, LocalContext.current)

  val view = LocalView.current
  if (!view.isInEditMode) {
    SideEffect {
      (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
      ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
    }
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography,
    content = content
  )
}