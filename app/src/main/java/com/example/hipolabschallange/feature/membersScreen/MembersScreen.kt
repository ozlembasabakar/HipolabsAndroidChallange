package com.example.hipolabschallange.feature.membersScreen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hipolabschallange.R
import com.example.hipolabschallange.designsystem.components.*
import com.example.hipolabschallange.designsystem.theme.*

@SuppressLint(
    "UnusedMaterial3ScaffoldPaddingParameter", "StateFlowValueCalledInComposition",
    "UnrememberedMutableState"
)
@Composable
fun MembersScreen() {

    val membersScreenViewModel: MembersScreenViewModel = hiltViewModel()
    val searchText by membersScreenViewModel.searchText.collectAsState()
    val members by membersScreenViewModel.members.collectAsState()

    val name = mutableStateOf("")

    val position = mutableStateOf("")

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        content =
        {
            if (membersScreenViewModel.isDialogVisible.value)
                AddNewMemberDialog(
                    onClick = {
                        membersScreenViewModel.addNewMember(
                            name.value,
                            position.value
                        )
                        Log.d(
                            "ozlem",
                            "members after adding new one: ${membersScreenViewModel.members.value}"
                        )
                    },
                    name = name,
                    position = position,
                    isError = membersScreenViewModel.isError,
                    isDialogVisible = membersScreenViewModel.isDialogVisible
                )

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
                    onValueChange = membersScreenViewModel::onSearchBarTextChanged
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
                        buttonText = stringResource(id = R.string.add_button_text),
                        onClick = {
                            membersScreenViewModel.isDialogVisible.value = true
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
    MembersScreen()
}