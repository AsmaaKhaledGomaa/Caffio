package com.asoom.caffio.core.designSystem

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.asoom.caffio.R

val SnigletFont = FontFamily(
    Font(R.font.sniglet_regular, FontWeight.Normal),
    Font(R.font.sniglet_extra_bold, FontWeight.ExtraBold)
)

val UrbanistFont = FontFamily(
    Font(R.font.urbanist_bold, FontWeight.Bold),
    Font(R.font.urbanist_extra_bold, FontWeight.ExtraBold)

)

val CaffioTypography = Typography(
    headlineLarge = TextStyle(
        fontFamily = SnigletFont,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 50.sp,
        letterSpacing = 0.25.sp
    ),
    titleLarge = TextStyle(
        fontFamily = SnigletFont,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelLarge = TextStyle(
        fontFamily = UrbanistFont,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 100.sp,
        letterSpacing = 0.25.sp
    ),
    labelMedium = TextStyle(
        fontFamily = SnigletFont,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 32.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    )
)