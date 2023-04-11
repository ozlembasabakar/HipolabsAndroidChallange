package com.example.hipolabschallange

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class AddNewMemberDialogScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun test_addNewMemberDialog_isVisible() {
        composeTestRule.onNodeWithTag("AddButton").performClick()
        Thread.sleep(1000)

        composeTestRule.onNodeWithTag("Dialog").assertExists()
    }

    @Test
    fun test_addNewMemberDialog_header_isVisible() {
        composeTestRule.onNodeWithTag("AddButton").performClick()
        Thread.sleep(1000)

        composeTestRule.onNodeWithTag("DialogHeader").assertExists()
    }

    @Test
    fun test_addNewMemberDialog_addButton_isVisible() {
        composeTestRule.onNodeWithTag("AddButton").performClick()
        Thread.sleep(1000)

        composeTestRule.onNodeWithTag("DialogAddButton").assertExists()
    }

    @Test
    fun test_addNewMemberDialog_addButton_isClickable() {
        composeTestRule.onNodeWithTag("AddButton").performClick()
        Thread.sleep(1000)

        composeTestRule.onNodeWithTag("DialogAddButton").assertHasClickAction()
    }

    @Test
    fun test_addNewMemberDialog_cancelButton_IsVisible() {
        composeTestRule.onNodeWithTag("AddButton").performClick()
        Thread.sleep(1000)

        composeTestRule.onNodeWithText("Cancel").assertExists()
    }

    @Test
    fun test_addNewMemberDialog_cancelButton_isClickable() {
        composeTestRule.onNodeWithTag("AddButton").performClick()
        Thread.sleep(1000)

        composeTestRule.onNodeWithText("Cancel").assertHasClickAction()
    }

    @Test
    fun test_addNewMemberDialog_namePlaceholder_isVisible() {
        composeTestRule.onNodeWithTag("AddButton").performClick()
        Thread.sleep(1000)

        composeTestRule.onNodeWithText("Name").assertExists()
    }

    @Test
    fun test_addNewMemberDialog_positionPlaceholder_isVisible() {
        composeTestRule.onNodeWithTag("AddButton").performClick()
        Thread.sleep(1000)

        composeTestRule.onNodeWithText("Position").assertExists()
    }

    @Test
    fun test_addNewMemberDialog_nameInput_isVisible() {

        val name = "Özlem"

        composeTestRule.onNodeWithTag("AddButton").performClick()
        Thread.sleep(1000)
        composeTestRule.onNodeWithText("Name").performTextInput(name)

        composeTestRule.onNodeWithTag("DialogInputNameField").assert(hasText(name))
    }

    @Test
    fun test_addNewMemberDialog_positionInput_isVisible() {

        val position = "Intern"

        composeTestRule.onNodeWithTag("AddButton").performClick()
        Thread.sleep(1000)
        composeTestRule.onNodeWithText("Position").performTextInput(position)

        composeTestRule.onNodeWithText(position).assertExists()
    }

    @Test
    fun test_addNewMemberDialog_invalidInput() {
        composeTestRule.onNodeWithTag("AddButton").performClick()
        Thread.sleep(1000)
        composeTestRule.onNodeWithText("Name").performTextInput("")
        composeTestRule.onNodeWithText("Position").performTextInput("")
        composeTestRule.onNodeWithTag("DialogAddButton").performClick()

        composeTestRule.onNodeWithTag("DialogAddButton").assertExists()
    }

    @Test
    fun test_addNewMemberDialog_twoInput_isValid() {

        val name = "Özlem"
        val position = "Intern"

        composeTestRule.onNodeWithTag("AddButton").performClick()
        Thread.sleep(1000)
        composeTestRule.onNodeWithText("Name").performTextInput(name)
        composeTestRule.onNodeWithText("Position").performTextInput(position)
        composeTestRule.onNodeWithTag("DialogAddButton").performClick()

        composeTestRule.onNodeWithTag("DialogAddButton").assertDoesNotExist()
    }

    @Test
    fun test_addNewMemberDialog_oneInput_isValid() {
        val name = "Özlem"

        composeTestRule.onNodeWithTag("AddButton").performClick()
        Thread.sleep(1000)
        composeTestRule.onNodeWithText("Name").performTextInput(name)
        composeTestRule.onNodeWithText("Position").performTextInput("")
        composeTestRule.onNodeWithTag("DialogAddButton").performClick()

        composeTestRule.onNodeWithTag("DialogAddButton").assertExists()
    }

    @Test
    fun test_addNewMemberDialog_return_validMemberList() {

        val name = "Özlem"
        val position = "Intern"

        composeTestRule.onNodeWithTag("AddButton").performClick()
        Thread.sleep(1000)
        composeTestRule.onNodeWithText("Name").performTextInput(name)
        composeTestRule.onNodeWithText("Position").performTextInput(position)
        composeTestRule.onNodeWithTag("DialogAddButton").performClick()

        composeTestRule.onNodeWithText(name).assertExists()
    }

    @Test
    fun test_addNewMemberDialog_headerColor_isTrue() {
        composeTestRule.onNodeWithTag("AddButton").performClick()
        Thread.sleep(1000)

        composeTestRule.onNodeWithTag("DialogHeader").assertColor(Color.Black)
    }
}