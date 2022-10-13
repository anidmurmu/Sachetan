package com.healthifyme.common_compose.units

import androidx.annotation.ColorRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource

public fun String?.parseColor(defaultColor: Color): Color {
    if (this.isNullOrEmpty()) return defaultColor
    return try {
        val androidColor = android.graphics.Color.parseColor(this)
        Color(androidColor)
    } catch (e: Exception) {
        defaultColor
    }
}

@Composable
public fun String?.parseColor(@ColorRes defaultColor: Int): Color {
    if (this.isNullOrEmpty()) return colorResource(defaultColor)
    return try {
        val androidColor = android.graphics.Color.parseColor(this)
        Color(androidColor)
    } catch (e: Exception) {
        colorResource(defaultColor)
    }
}
