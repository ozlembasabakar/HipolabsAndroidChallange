package com.example.hipolabschallange.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.example.hipolabschallange.R
import com.example.hipolabschallange.designsystem.theme.*

@Composable
fun AddNewMemberDialog(
    modifier: Modifier = Modifier,
    name: MutableState<String>,
    position: MutableState<String>,
    isDialogVisible: MutableState<Boolean>,
    isError: MutableState<Boolean>,
    onClick: (String) -> Unit,
) {

    Dialog(
        onDismissRequest = { },
        content =
        {
            Surface(
                shape = Shapes.medium,
                color = MaterialTheme.colorScheme.surface
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = modifier.padding(AddNewMemberDialogColumnPadding),
                        verticalArrangement = Arrangement.spacedBy(
                            AddNewMemberDialogColumnVerticalArrangementPadding
                        )
                    ) {

                        Text(
                            text = stringResource(id = R.string.add_new_member_dialog_label),
                            style = MaterialTheme.typography.headlineSmall,
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

                            AddNewMemberInputTextField(
                                inputText = name,
                                isError = isError,
                                background = MaterialTheme.colorScheme.secondaryContainer,
                                textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                                placeholder = stringResource(id = R.string.add_new_member_dialog_name_placeholder),
                            )

                            AddNewMemberInputTextField(
                                inputText = position,
                                isError = isError,
                                background = MaterialTheme.colorScheme.secondaryContainer,
                                textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                                placeholder = stringResource(id = R.string.add_new_member_dialog_position_placeholder),
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            AddNewMemberDialogActionButton(
                                buttonText = stringResource(id = R.string.add_new_member_dialog_cancel_button),
                                onClick = {
                                    isDialogVisible.value = false
                                }
                            )
                            Spacer(
                                modifier = Modifier.width(
                                    AddNewMemberDialogActionButtonsRowSpacer
                                )
                            )
                            AddNewMemberDialogActionButton(
                                buttonText = stringResource(R.string.add_new_member_dialog_add_button),
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
                        }
                    }
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNewMemberInputTextField(
    modifier: Modifier = Modifier,
    background: Color,
    textColor: Color,
    inputText: MutableState<String>,
    isError: MutableState<Boolean>,
    placeholder: String,
) {
    Box(
        modifier = Modifier
            .clip(Shapes.medium)
            .background(background)
            .fillMaxWidth()
            .shadow(
                elevation = RecordCardShadowElevation,
                shape = RectangleShape,
                spotColor = RecordCardShadowSpotColor
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        TextField(
            modifier = modifier
                .fillMaxWidth()
                .background(background),
            value = inputText.value,
            onValueChange = {
                inputText.value = it
                isError.value = false
            },
            textStyle = MaterialTheme.typography.displaySmall,
            singleLine = true,
            placeholder = {
                Text(
                    text = placeholder,
                    color = textColor,
                    style = MaterialTheme.typography.displaySmall
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            isError = isError.value,
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
            ),
        )
    }
}

@Composable
fun AddNewMemberDialogActionButton(
    buttonText: String,
    onClick: () -> Unit,
) {
    Text(
        text = buttonText,
        modifier = Modifier
            .clip(Shapes.large)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication =
                rememberRipple(bounded = true),
                onClick = onClick
            )
            .padding(AddNewMemberDialogActionButtonsPadding)
    )
}


@Preview
@Composable
fun AddNewMemberDialog_isError_Preview() {
    val name = remember { mutableStateOf("") }
    val position = remember { mutableStateOf("") }
    val isDialogVisible = remember { mutableStateOf(true) }
    val isError = remember { mutableStateOf(true) }

    HipolabsChallengeTheme {
        AddNewMemberDialog(
            name = name,
            position = position,
            isDialogVisible = isDialogVisible,
            isError = isError,
            onClick = {},
        )
    }
}

@Preview
@Composable
fun AddNewMemberDialogPreview() {
    val name = remember { mutableStateOf("") }
    val position = remember { mutableStateOf("") }
    val isDialogVisible = remember { mutableStateOf(true) }
    val isError = remember { mutableStateOf(false) }

    HipolabsChallengeTheme {
        AddNewMemberDialog(
            name = name,
            position = position,
            isDialogVisible = isDialogVisible,
            isError = isError,
            onClick = {},
        )
    }
}