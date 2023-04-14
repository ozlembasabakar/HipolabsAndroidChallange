package com.example.hipolabschallange.designsystem.components

import android.annotation.SuppressLint
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.example.hipolabschallange.R
import com.example.hipolabschallange.designsystem.theme.*

@SuppressLint("UnrememberedMutableState")
@Composable
fun Dialog(
    modifier: Modifier = Modifier,
    name: MutableState<String>,
    position: MutableState<String>,
    years_in_hipo: MutableState<String>,
    age: MutableState<String>,
    github: MutableState<String>,
    location: MutableState<String>,
    isDialogVisible: MutableState<Boolean>,
    isError: MutableState<Boolean>,
    onClick: (String) -> Unit,
    validateOfRecord: () -> Boolean,
) {

    Dialog(
        onDismissRequest = { }
    ) {
        Surface(
            modifier = modifier.testTag("Dialog"),
            shape = Shapes.medium,
            color = MaterialTheme.colorScheme.surface
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = modifier.padding(DialogColumnPadding),
                    verticalArrangement = Arrangement.spacedBy(
                        DialogColumnVerticalArrangementPadding
                    )
                ) {

                    Text(
                        modifier = Modifier.testTag("DialogHeader"),
                        text = stringResource(id = R.string.add_new_member_dialog_label),
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Divider(
                        modifier = Modifier
                            .clip(Shapes.medium)
                            .fillMaxWidth()
                            .height(DialogDividerHeight)
                            .background(MaterialTheme.colorScheme.onSurface)
                    )

                    Column(
                        verticalArrangement = Arrangement.spacedBy(
                            DialogTextFieldsColumnVerticalArrangementPadding
                        )
                    ) {

                        DialogInputTextField(
                            modifier = Modifier.testTag("DialogInputNameField"),
                            inputText = name,
                            isError = isError,
                            placeholder = stringResource(id = R.string.add_new_member_dialog_name_placeholder),
                        )

                        DialogInputTextField(
                            modifier = Modifier.testTag("DialogInputPositionField"),
                            inputText = position,
                            isError = isError,
                            placeholder = stringResource(id = R.string.add_new_member_dialog_position_placeholder),
                        )

                        DialogInputNumberField(
                            modifier = Modifier,
                            inputNumber = years_in_hipo,
                            isError = isError,
                            placeholder = stringResource(id = R.string.add_new_member_dialog_yearsInHipo_placeholder),
                        )

                        DialogInputNumberField(
                            modifier = Modifier,
                            inputNumber = age,
                            isError = isError,
                            placeholder = stringResource(id = R.string.add_new_member_dialog_age_placeholder),
                        )

                        DialogInputTextField(
                            modifier = Modifier,
                            inputText = github,
                            isError = isError,
                            placeholder = stringResource(id = R.string.add_new_member_dialog_github_placeholder),
                        )

                        DialogInputTextField(
                            modifier = Modifier,
                            inputText = location,
                            isError = isError,
                            placeholder = stringResource(id = R.string.add_new_member_dialog_location_placeholder),
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        DialogActionButton(
                            modifier = Modifier.testTag("DialogCancelButton"),
                            buttonText = stringResource(id = R.string.add_new_member_dialog_cancel_button),
                            onClick = {
                                isDialogVisible.value = false
                            }
                        )
                        Spacer(
                            modifier = Modifier.width(
                                DialogActionButtonsRowSpacer
                            )
                        )
                        DialogActionButton(
                            modifier = Modifier.testTag("DialogAddButton"),
                            buttonText = stringResource(R.string.add_new_member_dialog_add_button),
                            onClick = {
                                if (validateOfRecord()) {
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogInputTextField(
    modifier: Modifier = Modifier,
    inputText: MutableState<String>,
    isError: MutableState<Boolean>,
    placeholder: String,
) {
    Box(
        modifier = Modifier
            .clip(Shapes.medium)
            .background(MaterialTheme.colorScheme.primary)
            .fillMaxWidth()
            .shadow(
                elevation = DialogInputFieldShadowElevation,
                shape = RectangleShape,
                spotColor = DialogInputFieldShadowSpotColor
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        TextField(
            modifier = modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .testTag("DialogInputTextField"),
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
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.displaySmall
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            isError = isError.value,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                containerColor = MaterialTheme.colorScheme.primary,
                cursorColor = MaterialTheme.colorScheme.onPrimary,
                selectionColors = TextSelectionColors(
                    backgroundColor = MaterialTheme.colorScheme.primary.copy(alpha = DialogInputFieldTextColorAlpha),
                    handleColor = MaterialTheme.colorScheme.onPrimary
                )
            ),
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogInputNumberField(
    modifier: Modifier = Modifier,
    inputNumber: MutableState<String>,
    isError: MutableState<Boolean>,
    placeholder: String,
) {
    Box(
        modifier = Modifier
            .clip(Shapes.medium)
            .background(MaterialTheme.colorScheme.primary)
            .fillMaxWidth()
            .shadow(
                elevation = DialogInputFieldShadowElevation,
                shape = RectangleShape,
                spotColor = DialogInputFieldShadowSpotColor
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        TextField(
            modifier = modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary),
            value = inputNumber.value,
            onValueChange = {
                inputNumber.value = it
                isError.value = false
            },
            placeholder = {
                Text(
                    text = placeholder,
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.displaySmall
                )
            },
            textStyle = MaterialTheme.typography.displaySmall,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = isError.value,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                containerColor = MaterialTheme.colorScheme.primary,
                cursorColor = MaterialTheme.colorScheme.onPrimary,
                selectionColors = TextSelectionColors(
                    backgroundColor = MaterialTheme.colorScheme.primary.copy(alpha = DialogInputFieldTextColorAlpha),
                    handleColor = MaterialTheme.colorScheme.onPrimary
                )
            ),
        )
    }
}

@Composable
fun DialogActionButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    onClick: () -> Unit,
) {
    Text(
        text = buttonText,
        modifier = modifier
            .clip(Shapes.large)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication =
                rememberRipple(bounded = true),
                onClick = onClick
            )
            .padding(DialogActionButtonsPadding)
    )
}

@Composable
fun AddNewMemberDialog(
    modifier: Modifier = Modifier,
    name: MutableState<String>,
    position: MutableState<String>,
    years_in_hipo: MutableState<String>,
    age: MutableState<String>,
    github: MutableState<String>,
    location: MutableState<String>,
    isDialogVisible: MutableState<Boolean>,
    isError: MutableState<Boolean>,
    onClick: (String) -> Unit,
    validateOfRecord: () -> Boolean,
) {
    Dialog(
        modifier = modifier,
        name = name,
        position = position,
        years_in_hipo = years_in_hipo,
        age = age,
        github = github,
        location = location,
        isDialogVisible = isDialogVisible,
        isError = isError,
        onClick = onClick,
        validateOfRecord = validateOfRecord
    )
}


@Preview
@Composable
fun AddNewMemberDialog_isError_Preview() {
    val name = remember { mutableStateOf("") }
    val position = remember { mutableStateOf("") }
    val years_in_hipo = remember { mutableStateOf("") }
    val age = remember { mutableStateOf("") }
    val github = remember { mutableStateOf("") }
    val location = remember { mutableStateOf("") }
    val isDialogVisible = remember { mutableStateOf(true) }
    val isError = remember { mutableStateOf(true) }

    HipolabsChallengeTheme {
        AddNewMemberDialog(
            name = name,
            position = position,
            years_in_hipo = years_in_hipo,
            age = age,
            github = github,
            location = location,
            isDialogVisible = isDialogVisible,
            isError = isError,
            onClick = {},
            validateOfRecord = { true }
        )
    }
}

@Preview
@Composable
fun AddNewMemberDialogPreview() {
    val name = remember { mutableStateOf("") }
    val position = remember { mutableStateOf("") }
    val years_in_hipo = remember { mutableStateOf("") }
    val age = remember { mutableStateOf("") }
    val github = remember { mutableStateOf("") }
    val location = remember { mutableStateOf("") }
    val isDialogVisible = remember { mutableStateOf(true) }
    val isError = remember { mutableStateOf(false) }

    HipolabsChallengeTheme {
        AddNewMemberDialog(
            name = name,
            position = position,
            years_in_hipo = years_in_hipo,
            age = age,
            github = github,
            location = location,
            isDialogVisible = isDialogVisible,
            isError = isError,
            onClick = {},
            validateOfRecord = { true }
        )
    }
}