package com.example.hipolabschallange.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hipolabschallange.MainScreenViewModel
import com.example.hipolabschallange.R
import com.example.hipolabschallange.ui.theme.*

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val mainScreenViewModel: MainScreenViewModel = hiltViewModel()
    val searchText by mainScreenViewModel.searchText.collectAsState()
    val persons by mainScreenViewModel.persons.collectAsState()

    val focusManager = LocalFocusManager.current

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

/*                SearchBar(
                    Modifier.padding(horizontal = MainScreenSearchBarHorizontalPadding),
                    value = searchText,
                    onValueChange = mainScreenViewModel::onSearchBarTextChanged
                )*/

                Row(
                    modifier = Modifier
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
                        value = searchText,
                        onValueChange = mainScreenViewModel::onSearchBarTextChanged,
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

                LazyColumn(
                    modifier = Modifier.weight(MainScreenLazyColumnWeight),
                    contentPadding = PaddingValues(
                        horizontal = MainScreenLazyColumnHorizontalPadding
                    ),
                    verticalArrangement = Arrangement.spacedBy(
                        MainScreenLazyColumnVerticalArrangementSpacedBy
                    ),
                ) {

                    items(persons) {
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