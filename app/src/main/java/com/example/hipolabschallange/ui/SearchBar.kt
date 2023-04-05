package com.example.hipolabschallange.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.hipolabschallange.R
import com.example.hipolabschallange.ui.theme.*

@Composable
fun SearchBar(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {
    val focusManager = LocalFocusManager.current

    Row(
        modifier = modifier
            .border(SearchBarBorder, color = SearchBarStroke, shape = Shapes.medium)
            .clip(Shapes.medium)
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(
                vertical = SearchBarVerticalPadding
            )
            .fillMaxWidth()
            .shadow(
                elevation = SearchBarShadowElevation,
                shape = RectangleShape,
                spotColor = SearchBarShadowSpotColor
            ),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.search_icon),
            contentDescription = "",
            modifier = Modifier.padding(
                horizontal = SearchBarIconHorizontalPadding
            )
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            textStyle = MaterialTheme.typography.bodyMedium,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            )
        )
    }
}

@Preview
@Composable
fun PreviewSearchBar() {
    SearchBar(Modifier, value = "", onValueChange = {})
}
