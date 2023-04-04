package com.example.hipolabschallange.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hipolabschallange.ui.theme.RecordCardStroke
import com.example.hipolabschallange.ui.theme.Shapes

@Composable
fun RecordCard(
    modifier: Modifier,
    text: String
) {
    Row(
        modifier = modifier
            .border(1.dp, color = RecordCardStroke, shape = Shapes.medium)
            .clip(Shapes.medium)
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(
                vertical = 15.dp,
                horizontal = 18.dp
            )
            .fillMaxWidth()
            .shadow(elevation = 2.dp, shape = RectangleShape, spotColor = Color(0xFFE9E9F1)),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
fun PreviewRecordCard() {
    RecordCard(Modifier, "asd")
}
