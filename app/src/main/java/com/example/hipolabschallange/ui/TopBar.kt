package com.example.hipolabschallange.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import com.example.hipolabschallange.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier,
    topBarText: String,
) {
    TopAppBar(
        title = {
            Text(
                modifier = Modifier.padding(
                    start = TopBarTextPaddingStart,
                    top = TopBarTextPaddingTop,
                    bottom = TopBarTextPaddingBottom
                ),
                text = topBarText,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = TopBarTextColorAlpha)
            )
        },
        modifier = modifier
            .background(MaterialTheme.colorScheme.surface)
            .shadow(
                elevation = TopBarShadowElevation,
                spotColor = TopBarShadowSpotColor
            )
    )
}

@Preview
@Composable
fun PreviewTopBar() {
    TopBar(modifier = Modifier, topBarText = "Members")
}