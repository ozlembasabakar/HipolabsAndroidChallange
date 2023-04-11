package com.example.hipolabschallange.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.hipolabschallange.R
import com.example.hipolabschallange.designsystem.icon.AppIcons.SearchIcon
import com.example.hipolabschallange.designsystem.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {
    val focusManager = LocalFocusManager.current

    Row(
        modifier = modifier
            .clip(Shapes.small)
            .border(SearchBarBorder, color = SearchBarStroke, shape = Shapes.small)
            .background(MaterialTheme.colorScheme.primaryContainer)
            .fillMaxWidth()
            .shadow(
                elevation = SearchBarShadowElevation,
                shape = RectangleShape,
                spotColor = SearchBarShadowSpotColor
            )
            .testTag("SearchBar"),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = SearchIcon),
            contentDescription = stringResource(id = R.string.search_icon_description),
            modifier = Modifier.padding(
                start = SearchBarIconPadding
            )
                .testTag("SearchBarIcon")
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer)
                .testTag("SearchBarInput"),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            textStyle = MaterialTheme.typography.bodyLarge,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                cursorColor = MaterialTheme.colorScheme.onPrimaryContainer,
                selectionColors = TextSelectionColors(
                    backgroundColor = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = SearchBarTextColorAlpha),
                    handleColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        )
    }
}

@Preview
@Composable
fun PreviewSearchBar() {
    HipolabsChallengeTheme {
        SearchBar(Modifier, value = "", onValueChange = {})
    }
}
