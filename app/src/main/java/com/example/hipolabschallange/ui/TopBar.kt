package com.example.hipolabschallange.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(
    modifier: Modifier,
    topBarText: String,
) {
    SmallTopAppBar(
        title = {
            Text(
                modifier = Modifier.padding(
                    start = 28.dp, top = 16.dp, bottom = 16.dp
                ),
                text = topBarText,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = .87f)
            )
        },
        modifier = modifier
            .background(MaterialTheme.colorScheme.surface)
            .shadow(elevation = 10.dp, spotColor = Color.Black)
    )
}

@Preview
@Composable
fun PreviewTopBar() {
    TopBar(modifier = Modifier, topBarText = "Members")
}