package com.heinika.styleclock.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.heinika.styleclock.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val dancingScriptFontFamily = FontFamily(
    Font(R.font.dancingscript_bold, FontWeight.Bold),
    Font(R.font.dancingscript_medium, FontWeight.Medium),
    Font(R.font.dancingscript_regular, FontWeight.Normal),
    Font(R.font.dancingscript_semibold, FontWeight.SemiBold)
)

val antonFamily = FontFamily(
    Font(R.font.anton_regular, FontWeight.Normal),
)

val lobsterFamily = FontFamily(
    Font(R.font.lobster_regular,FontWeight.Normal)
)

val cormorantgaramondFamily = FontFamily(
    Font(R.font.cormorantgaramond_regular,FontWeight.Normal)
)

val caveatFamily = FontFamily(
    Font(R.font.caveat,FontWeight.Normal)
)

val bahianitaFamily = FontFamily(
    Font(R.font.bahianita_regular,FontWeight.Normal)
)

val blakaFamily = FontFamily(
    Font(R.font.blaka_regular,FontWeight.Normal)
)

val blakahollowFamily = FontFamily(
    Font(R.font.blakahollow_regular,FontWeight.Normal)
)

val monotonFamily = FontFamily(
    Font(R.font.monoton_regular,FontWeight.Normal)
)

val josefinsansFamily = FontFamily(
    Font(R.font.josefinsans_regular,FontWeight.Normal)
)

val bungeeshadeFamily = FontFamily(
    Font(R.font.bungeeshade_regular,FontWeight.Normal)
)

enum class MyFontFamily(val fontFamily: FontFamily?){
    DefaultFontFamily(null),
    DancingScriptFontFamily(dancingScriptFontFamily),
    AntonFamily(antonFamily),
    LobsterFamily(lobsterFamily),
    Cormorantgaramond(cormorantgaramondFamily),
    Caveat(caveatFamily),
    BlakaFamily(blakaFamily),
    BlakahollowFamily(blakahollowFamily),
    BahianitaFamily(bahianitaFamily),
    MonotonFamily(monotonFamily),
    JosefinsansFamily(josefinsansFamily),
    BungeeshadeFamily(bungeeshadeFamily),
}