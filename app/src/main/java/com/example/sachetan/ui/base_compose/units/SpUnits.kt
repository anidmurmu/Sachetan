package com.healthifyme.common_compose.units

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

public object BaseTextSize {
    public val VerySmall: TextUnit = 10.sp
    public val Small: TextUnit = 12.sp
    public val Medium: TextUnit = 14.sp
    public val XMedium: TextUnit = 16.sp
    public val XXMedium: TextUnit = 18.sp

    public object Heading {
        public val Small: TextUnit = 20.sp
        public val Default: TextUnit = 24.sp
        public val Large: TextUnit = 28.sp
    }
}
