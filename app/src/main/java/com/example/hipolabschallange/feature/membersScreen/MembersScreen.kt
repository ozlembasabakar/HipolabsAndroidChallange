package com.example.hipolabschallange.feature.membersScreen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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
    val searchText by membersScreenViewModel.searchText.collectAsStateWithLifecycle()
    val members by membersScreenViewModel.members.collectAsStateWithLifecycle()

    val name = membersScreenViewModel.name
    val position = membersScreenViewModel.position
    val yearsInHipo = membersScreenViewModel.yearsInHipo
    val age = membersScreenViewModel.age
    val github = membersScreenViewModel.github
    val location = membersScreenViewModel.location

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        content =
        {
            if (membersScreenViewModel.isDialogVisible.value)
                AddNewMemberDialog(
                    onClick = {
                        membersScreenViewModel.addNewMember(
                            name.value,
                            position.value,
                            yearsInHipo.value,
                            age.value,
                            github.value,
                            location.value
                        )

                        name.value = ""
                        position.value = ""
                        yearsInHipo.value = ""
                        age.value = ""
                        github.value = ""
                        location.value = ""

                        Log.d(
                            "ozlem",
                            "members after adding new one: ${membersScreenViewModel.members.value}"
                        )
                    },
                    name = name,
                    position = position,
                    years_in_hipo = yearsInHipo,
                    age = age,
                    github = github,
                    location = location,
                    isError = membersScreenViewModel.isError,
                    isDialogVisible = membersScreenViewModel.isDialogVisible,
                    validateOfRecord = membersScreenViewModel::validateOfRecord
                )

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(MembersScreenVerticalArrangementSpacedBy),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                TopBar(modifier = Modifier, topBarText = stringResource(id = R.string.top_bar_text))

                SearchBar(
                    Modifier.padding(horizontal = MembersScreenSearchBarHorizontalPadding),
                    value = searchText,
                    onValueChange = membersScreenViewModel::onSearchBarTextChanged
                )

                MemberList(
                    modifier = Modifier
                        .weight(MemberListWeight),
                    items = members
                )

                Column(
                    modifier = Modifier
                        .padding(
                            start = MembersScreenAddButtonColumnPaddingStart,
                            end = MembersScreenAddButtonColumnPaddingEnd,
                            bottom = MembersScreenAddButtonColumnPaddingBottom
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