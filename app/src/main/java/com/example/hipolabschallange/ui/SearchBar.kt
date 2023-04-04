package com.example.hipolabschallange.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.hipolabschallange.R
import com.example.hipolabschallange.ui.theme.*

@Composable
fun SearchBar(
    modifier: Modifier
) {
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
        Text(text = "Search")
    }
}

@Preview
@Composable
fun PreviewSearchBar() {
    SearchBar(Modifier)
}
