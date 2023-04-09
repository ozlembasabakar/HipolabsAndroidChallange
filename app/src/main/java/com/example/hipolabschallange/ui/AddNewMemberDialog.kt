package com.example.hipolabschallange.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.hipolabschallange.R
import com.example.hipolabschallange.ui.theme.*

@Composable
fun AddNewMemberDialog(
    name: MutableState<String>,
    position: MutableState<String>,
    isDialogVisible: MutableState<Boolean>,
    isError: MutableState<Boolean>,
    onClick: (String) -> Unit,
) {

    HipolabsChallangeTheme {
        Dialog(onDismissRequest = { }
        ) {
            Surface(
                shape = Shapes.medium,
                color = MaterialTheme.colorScheme.surface
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier.padding(AddNewMemberDialogColumnPadding),
                        verticalArrangement = Arrangement.spacedBy(
                            AddNewMemberDialogColumnVerticalArrangementPadding
                        )
                    ) {

                        Text(
                            text = stringResource(id = R.string.add_new_member_dialog_label),
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Divider(
                            modifier = Modifier
                                .clip(Shapes.medium)
                                .fillMaxWidth()
                                .height(AddNewMemberDialogDividerHeight)
                                .background(MaterialTheme.colorScheme.onSurface)
                        )

                        Column(
                            verticalArrangement = Arrangement.spacedBy(
                                AddNewMemberDialogTextFieldsColumnVerticalArrangementPadding
                            )
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(Shapes.medium)
                                    .background(MaterialTheme.colorScheme.secondaryContainer)
                                    .fillMaxWidth()
                                    .shadow(
                                        elevation = RecordCardShadowElevation,
                                        shape = RectangleShape,
                                        spotColor = RecordCardShadowSpotColor
                                    ),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                TextField(
                                    value = name.value,
                                    onValueChange = {
                                        name.value = it
                                        isError.value = false
                                    },
                                    singleLine = true,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(MaterialTheme.colorScheme.secondaryContainer),
                                    placeholder = {
                                        Text(
                                            text = stringResource(id = R.string.add_new_member_dialog_name_placeholder),
                                            color = MaterialTheme.colorScheme.onSecondaryContainer
                                        )
                                    },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                                    isError = isError.value,
                                )
                            }

                            Box(
                                modifier = Modifier
                                    .clip(Shapes.medium)
                                    .background(MaterialTheme.colorScheme.secondaryContainer)
                                    .fillMaxWidth()
                                    .shadow(
                                        elevation = RecordCardShadowElevation,
                                        shape = RectangleShape,
                                        spotColor = RecordCardShadowSpotColor
                                    ),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                TextField(
                                    value = position.value,
                                    onValueChange = {
                                        position.value = it
                                        isError.value = false
                                    },
                                    singleLine = true,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(MaterialTheme.colorScheme.secondaryContainer),
                                    placeholder = {
                                        Text(
                                            text = stringResource(id = R.string.add_new_member_dialog_position_placeholder),
                                            color = MaterialTheme.colorScheme.onSecondaryContainer
                                        )
                                    },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                                    isError = isError.value,
                                )
                            }
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(
                                text = stringResource(R.string.add_new_member_dialog_cancel_button),
                                modifier = Modifier.clickable(
                                    onClick = {
                                        isDialogVisible.value = false
                                    }
                                )
                            )
                            Spacer(modifier = Modifier.width(15.dp))
                            Text(
                                text = stringResource(R.string.add_new_member_dialog_add_button),
                                modifier = Modifier.clickable(
                                    onClick = {
                                        if (position.value.isBlank() || name.value.isBlank()) {
                                            isError.value = true
                                            isDialogVisible.value = true
                                        } else {
                                            isError.value = false
                                            isDialogVisible.value = false
                                            onClick(name.value)
                                        }
                                    }
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun AddNewMemberDialogPreview() {
    val name = remember { mutableStateOf("") }
    val position = remember { mutableStateOf("") }
    val isDialogVisible = remember { mutableStateOf(true) }
    val isError = remember { mutableStateOf(false) }

    HipolabsChallangeTheme {
        AddNewMemberDialog(
            name = name,
            position = position,
            isDialogVisible = isDialogVisible,
            isError = isError
        ) {}
    }
}