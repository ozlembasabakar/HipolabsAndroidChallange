package com.example.hipolabschallange.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hipolabschallange.MainScreenViewModel
import com.example.hipolabschallange.R
import com.example.hipolabschallange.ui.theme.*

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "StateFlowValueCalledInComposition",
    "UnrememberedMutableState"
)
@Composable
fun MainScreen() {

    val mainScreenViewModel: MainScreenViewModel = hiltViewModel()
    val searchText by mainScreenViewModel.searchText.collectAsState()
    val members by mainScreenViewModel.members.collectAsState()

    val name = mutableStateOf("")

    val position = mutableStateOf("")

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        content =
        {
            if (mainScreenViewModel.isDialogVisible.value) {
                AddNewMemberDialog(
                    onClick = {
                        mainScreenViewModel.addNewMember(
                            name.value,
                            position.value
                        )
                        Log.d("ozlem", "members: ${mainScreenViewModel.members.value}")
                    },
                    name = name,
                    position = position,
                    isError = mainScreenViewModel.isError,
                    isDialogVisible = mainScreenViewModel.isDialogVisible
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(MainScreenVerticalArrangementSpacedBy),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                TopBar(modifier = Modifier, topBarText = stringResource(id = R.string.top_bar_text))

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
                    items(members.member) {
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
                        buttonText = stringResource(id = R.string.add_button_text),
                        onClick = {
                            mainScreenViewModel.isDialogVisible.value = true
                        }
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