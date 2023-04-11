package com.example.hipolabschallange

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class SearchBarScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun test_searchBar_icon_isVisible() {
        composeTestRule.onNodeWithTag("SearchBarIcon").assertExists()
    }

    @Test
    fun test_searchBar_isVisible() {
        composeTestRule.onNodeWithTag("SearchBar").assertExists()
    }

    @Test
    fun test_searchBar_textInput_isVisible() {

        val searchText = "Search"

        composeTestRule.onNodeWithTag("SearchBarTextInput").performClick()
        composeTestRule.onNodeWithTag("SearchBarTextInput").performTextInput(searchText)

        composeTestRule.onNodeWithTag("SearchBarTextInput").assertTextContains(searchText)
    }

    @Test
    fun test_searchBar_return_memberList_withValidInput() {

        val name = "Yasin Cetiner"

        composeTestRule.onNodeWithTag("SearchBarTextInput").performClick()
        composeTestRule.onNodeWithTag("SearchBarTextInput").performTextInput(name)
        Thread.sleep(500)

        composeTestRule.onNodeWithTag("RecordCardList").assertExists()
    }

    @Test
    fun test_searchBar_return_emptyMemberList_withInvalidInput() {

        val name = "123"

        composeTestRule.onNodeWithTag("SearchBarTextInput").performClick()
        composeTestRule.onNodeWithTag("SearchBarTextInput").performTextInput(name)
        Thread.sleep(1000)

        composeTestRule.onNodeWithTag("RecordCard").assertDoesNotExist()
    }

    @Test
    fun test_searchBar_return_validMemberList_withFullNameAndNoGap() {

        val name = "Yasin Cetiner"
        val searchText = name.replace(" ", "")

        composeTestRule.onNodeWithTag("SearchBarTextInput").performClick()
        composeTestRule.onNodeWithTag("SearchBarTextInput").performTextInput(searchText)
        Thread.sleep(1000)

        composeTestRule.onAllNodes(hasTestTag("RecordCardText")).apply {
            fetchSemanticsNodes().forEachIndexed { i, _ ->
                get(i).assertTextContains(name)
            }
        }
    }

    @Test
    fun test_searchBar_return_validMemberList_withFullName() {

        val searchText = "Yasin Cetiner"
        val name = "Yasin Cetiner"

        composeTestRule.onNodeWithTag("SearchBarTextInput").performClick()
        composeTestRule.onNodeWithTag("SearchBarTextInput").performTextInput(searchText)
        Thread.sleep(1000)

        composeTestRule.onAllNodes(hasTestTag("RecordCardText")).apply {
            fetchSemanticsNodes().forEachIndexed { i, _ ->
                get(i).assertTextContains(name)
            }
        }
    }

    @Test
    fun test_searchBar_return_validMemberList_withCommonLetter() {

        val searchText = "m"
        val name = "Miraç Özkan"

        composeTestRule.onNodeWithTag("SearchBarTextInput").performClick()
        composeTestRule.onNodeWithTag("SearchBarTextInput").performTextInput(searchText)

        composeTestRule.onAllNodes(hasTestTag("RecordCardText")).apply {
            fetchSemanticsNodes().forEachIndexed { i, _ ->
                get(i).assertTextContains(name)
            }
        }
    }

    @Test
    fun test_searchBar_return_validMemberList_withFullName_uppercase() {

        val name = "Yasin Cetiner"
        val searchText = name.uppercase()

        composeTestRule.onNodeWithTag("SearchBarTextInput").performClick()
        composeTestRule.onNodeWithTag("SearchBarTextInput").performTextInput(searchText)
        Thread.sleep(500)

        composeTestRule.onNodeWithText(name).assertExists()
    }

    @Test
    fun test_searchBar_return_validMemberList_withFullName_lowercase() {

        val name = "Yasin Cetiner"
        val searchText = name.lowercase()

        composeTestRule.onNodeWithTag("SearchBarTextInput").performClick()
        composeTestRule.onNodeWithTag("SearchBarTextInput").performTextInput(searchText)
        Thread.sleep(500)

        composeTestRule.onNodeWithText(name).assertExists()
    }

    @Test
    fun test_searchBar_return_validMemberList_withUniqueLetter() {

        val search = "y"
        val name = "Yasin Cetiner"

        composeTestRule.onNodeWithTag("SearchBarTextInput").performClick()
        composeTestRule.onNodeWithTag("SearchBarTextInput").performTextInput(search)
        Thread.sleep(500)

        composeTestRule.onNodeWithText(name).assertExists()
    }
}