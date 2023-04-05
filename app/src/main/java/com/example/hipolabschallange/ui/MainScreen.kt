package com.example.hipolabschallange.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hipolabschallange.MainScreenViewModel
import com.example.hipolabschallange.ui.theme.*

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val mainScreenViewModel: MainScreenViewModel = hiltViewModel()
    val searchText by mainScreenViewModel.searchText.collectAsState()
    val members by mainScreenViewModel.members.collectAsState()

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
                    Modifier.padding(horizontal = MainScreenSearchBarHorizontalPadding),
                    value = searchText,
                    onValueChange = mainScreenViewModel::onSearchBarTextChanged
                )

                LazyColumn(
                    modifier = Modifier.weight(MainScreenLazyColumnWeight),
                    contentPadding = PaddingValues(
                        horizontal = MainScreenLazyColumnHorizontalPadding
                    ),
                    verticalArrangement = Arrangement.spacedBy(
                        MainScreenLazyColumnVerticalArrangementSpacedBy
                    ),
                ) {

                    items(members) {
                        RecordCard(
                            modifier = Modifier,
                            recordText = it.name
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