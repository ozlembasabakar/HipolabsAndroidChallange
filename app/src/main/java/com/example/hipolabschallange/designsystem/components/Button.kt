package com.example.hipolabschallange.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.example.hipolabschallange.designsystem.theme.ButtonHorizontalPadding
import com.example.hipolabschallange.designsystem.theme.ButtonVerticalPadding
import com.example.hipolabschallange.designsystem.theme.HipolabsChallengeTheme
import com.example.hipolabschallange.designsystem.theme.Shapes


@Composable
fun Button(
    modifier: Modifier,
    buttonText: String,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .clip(Shapes.large)
            .clickable(
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication =
                rememberRipple(bounded = true),
            )
            .background(MaterialTheme.colorScheme.tertiaryContainer)
            .padding(
                vertical = ButtonVerticalPadding,
                horizontal = ButtonHorizontalPadding
            )
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = buttonText,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onTertiaryContainer
        )
    }

}

@Composable
fun AddButton(
    modifier: Modifier,
    buttonText: String,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.testTag("AddButton"),
        buttonText = buttonText,
        onClick = onClick
    )
}

@Preview
@Composable
fun PreviewAddButton() {
    HipolabsChallengeTheme {
        AddButton(modifier = Modifier, buttonText = "ADD NEW MEMBER", onClick = {})
    }
}