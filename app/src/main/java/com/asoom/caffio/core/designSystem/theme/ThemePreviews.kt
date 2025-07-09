package com.asoom.caffio.core.designSystem.theme

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview


@Preview(
    name = "Pixel 8 Pro - Light",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    locale = "en",
    device = "spec:width=412dp,height=915dp,dpi=560"
)
@Preview(
    name = "Pixel 8 Pro - Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    locale = "en",
    device = "spec:width=412dp,height=915dp,dpi=560"
)

@Preview(
    name = "LIGHT - Small",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    locale = "en",
    device = "spec:width=360dp,height=640dp,dpi=480"
)
@Preview(
    name = "DARK - Medium",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    locale = "en",
    device = "spec:width=411dp,height=891dp,dpi=420"
)

@Preview(
    name = "LIGHT - Large",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    locale = "en",
    device = "spec:width=800dp,height=1280dp,dpi=320"
)
@Preview(
    name = "DARK - Large",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    locale = "en",
    device = "spec:width=800dp,height=1280dp,dpi=320"
)
@Preview(
    name = "Arabic - RTL",
    showBackground = true,
    locale = "ar",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    device = "spec:width=411dp,height=891dp,dpi=420"
)
annotation class ThemePreviews