package com.example.hipolabschallange.designsystem.components

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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.example.hipolabschallange.designsystem.theme.*

@Composable
fun Card(
    modifier: Modifier,
    text: String?,
) {
    Box(
        modifier = modifier
            .border(CardBorder, color = CardStroke, shape = Shapes.small)
            .clip(Shapes.small)
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(
                vertical = CardVerticalPadding,
                horizontal = CardHorizontalPadding
            )
            .fillMaxWidth()
            .shadow(
                elevation = CardShadowElevation,
                shape = RectangleShape,
                spotColor = CardShadowSpotColor
            )
            .testTag("Card"),
        contentAlignment = Alignment.CenterStart
    ) {
        if (text != null) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}

@Composable
fun RecordCard(
    modifier: Modifier,
    recordText: String?,
) {
    Card(
        modifier = modifier,
        text = recordText
    )
}

@Preview
@Composable
fun PreviewRecordCard() {
    HipolabsChallengeTheme {
        RecordCard(Modifier, "Özlem Başabakar")
    }
}
