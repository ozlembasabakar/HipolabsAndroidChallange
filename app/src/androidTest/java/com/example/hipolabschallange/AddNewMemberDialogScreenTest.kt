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
    fun test_addNewMemberDialog_dialogInputTextFieldPlaceholder_isVisible() {

        val name = "Name"

        composeTestRule.onNodeWithTag("AddButton").performClick()
        Thread.sleep(1000)

        composeTestRule.onAllNodes(hasTestTag("DialogInputTextField")).apply {
            fetchSemanticsNodes().forEachIndexed { i, _ ->
                get(i).assertTextContains(name)
            }
        }
    }

    @Test
    fun test_addNewMemberDialog_dialogInputNumberFieldPlaceholder_isVisible() {

        val age = "Age"

        composeTestRule.onNodeWithTag("AddButton").performClick()
        Thread.sleep(1000)

        composeTestRule.onNodeWithText(age).assertExists()
    }

    @Test
    fun test_addNewMemberDialog_dialogInputTextField_isVisible() {

        val name = "Özlem"

        composeTestRule.onNodeWithTag("AddButton").performClick()
        Thread.sleep(1000)
        composeTestRule.onNodeWithText("Name").performTextInput(name)

        composeTestRule.onAllNodes(hasTestTag("DialogInputTextField")).apply {
            fetchSemanticsNodes().forEachIndexed { i, _ ->
                get(i).assertTextContains(name)
            }
        }
    }

    @Test
    fun test_addNewMemberDialog_dialogInputNumberField_isVisible() {

        val age = "27"

        composeTestRule.onNodeWithTag("AddButton").performClick()
        Thread.sleep(1000)
        composeTestRule.onNodeWithText("Age").performTextInput(age)

        composeTestRule.onNodeWithText(age).assertExists()
    }

    @Test
    fun test_addNewMemberDialog_invalidInput() {

        val name = ""
        val position = ""
        val yearsInHipo = ""
        val age = ""
        val github = ""
        val location = ""

        composeTestRule.onNodeWithTag("AddButton").performClick()
        Thread.sleep(1000)
        composeTestRule.onNodeWithText("Name").performTextInput(name)
        composeTestRule.onNodeWithText("Position").performTextInput(position)
        composeTestRule.onNodeWithText("Years In Hipo").performTextInput(yearsInHipo)
        composeTestRule.onNodeWithText("Age").performTextInput(age)
        composeTestRule.onNodeWithText("Github").performTextInput(github)
        composeTestRule.onNodeWithText("Location").performTextInput(location)
        composeTestRule.onNodeWithTag("DialogAddButton").performClick()

        composeTestRule.onNodeWithTag("DialogAddButton").assertExists()
    }

    @Test
    fun test_addNewMemberDialog_oneInput_isValid() {

        val name = "Özlem"
        val position = ""
        val yearsInHipo = "0"
        val age = "27"
        val github = "asd@asd.com"
        val location = "Istanbul"

        composeTestRule.onNodeWithTag("AddButton").performClick()
        Thread.sleep(1000)
        composeTestRule.onNodeWithText("Name").performTextInput(name)
        composeTestRule.onNodeWithText("Position").performTextInput(position)
        composeTestRule.onNodeWithText("Years In Hipo").performTextInput(yearsInHipo)
        composeTestRule.onNodeWithText("Age").performTextInput(age)
        composeTestRule.onNodeWithText("Github").performTextInput(github)
        composeTestRule.onNodeWithText("Location").performTextInput(location)
        composeTestRule.onNodeWithTag("DialogAddButton").performClick()

        composeTestRule.onNodeWithTag("DialogAddButton").assertExists()
    }

    @Test
    fun test_addNewMemberDialog_return_validMemberList() {

        val name = "Özlem"
        val position = "Intern"
        val yearsInHipo = "0"
        val age = "27"
        val github = "asd@asd.com"
        val location = "Istanbul"

        composeTestRule.onNodeWithTag("AddButton").performClick()
        Thread.sleep(1000)
        composeTestRule.onNodeWithText("Name").performTextInput(name)
        composeTestRule.onNodeWithText("Position").performTextInput(position)
        composeTestRule.onNodeWithText("Years In Hipo").performTextInput(yearsInHipo)
        composeTestRule.onNodeWithText("Age").performTextInput(age)
        composeTestRule.onNodeWithText("Github").performTextInput(github)
        composeTestRule.onNodeWithText("Location").performTextInput(location)
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