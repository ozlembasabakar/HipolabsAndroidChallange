package com.example.hipolabschallange.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hipolabschallange.ui.theme.*

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        content =
        {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(MainScreenVerticalArrangementSpacedBy),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                TopBar(modifier = Modifier, topBarText = "Members")

                SearchBar(
                    Modifier.padding(horizontal = MainScreenSearchBarHorizontalPadding)
                )

                LazyColumn(
                    modifier = Modifier.weight(MainScreenLazyColumnWeight),
                    contentPadding = PaddingValues(
                        horizontal = MainScreenLazyColumnHorizontalPadding
                    ),
                    verticalArrangement = Arrangement.spacedBy(MainScreenLazyColumnVerticalArrangementSpacedBy),
                ) {

                    items(25) {
                        RecordCard(
                            modifier = Modifier,
                            recordText = "Item $it"
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .padding(
                            start = MainScreenAddButtonColumnPaddingStart,
                            end = MainScreenAddButtonColumnPaddingEnd,
                            bottom = MainScreenAddButtonColumnPaddingBottom
                        )
                ) {
                    AddButton(
                        modifier = Modifier,
                        buttonText = "ADD NEW MEMBER"
                    )
                }
            }
        }
    )
}


@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen()
}