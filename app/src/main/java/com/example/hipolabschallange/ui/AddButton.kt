package com.example.hipolabschallange.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.example.hipolabschallange.ui.theme.AddButtonHorizontalPadding
import com.example.hipolabschallange.ui.theme.AddButtonVerticalPadding
import com.example.hipolabschallange.ui.theme.Shapes

@Composable
fun AddButton(
    modifier: Modifier,
    buttonText: String,
    onClick: () -> Unit,
) {

    Box(
        modifier = modifier
            .clip(Shapes.large)
            .background(MaterialTheme.colorScheme.tertiaryContainer)
            .padding(
                vertical = AddButtonVerticalPadding,
                horizontal = AddButtonHorizontalPadding
            )
            .fillMaxWidth()
            .clickable(
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = buttonText,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onTertiaryContainer
        )
    }
}

@Preview
@Composable
fun PreviewAddButton() {
    AddButton(modifier = Modifier, buttonText = "ADD NEW MEMBER", onClick = {})
}