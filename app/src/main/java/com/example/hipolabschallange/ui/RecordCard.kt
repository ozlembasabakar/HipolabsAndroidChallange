package com.example.hipolabschallange.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import com.example.hipolabschallange.ui.theme.*

@Composable
fun RecordCard(
    modifier: Modifier,
    recordText: String?,
) {
    Box(
        modifier = modifier
            .border(RecordCardBorder, color = RecordCardStroke, shape = Shapes.small)
            .clip(Shapes.small)
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(
                vertical = RecordCardVerticalPadding,
                horizontal = RecordCardHorizontalPadding
            )
            .fillMaxWidth()
            .shadow(
                elevation = RecordCardShadowElevation,
                shape = RectangleShape,
                spotColor = RecordCardShadowSpotColor
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        if (recordText != null) {
            Text(
                text = recordText,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}

@Preview
@Composable
fun PreviewRecordCard() {
    RecordCard(Modifier, "Özlem Başabakar")
}
