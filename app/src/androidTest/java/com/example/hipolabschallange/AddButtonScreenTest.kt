package com.example.hipolabschallange

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.hipolabschallange.designsystem.theme.AddButton
import org.junit.Assert.assertEquals
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runners.MethodSorters

fun SemanticsNodeInteraction.assertColor(expectedColor: Color) {
    val capturedName = captureToImage().colorSpace.name
    assertEquals(expectedColor.colorSpace.name, capturedName)
}

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class AddButtonScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun test_addButton_isVisible() {
        composeTestRule.onNodeWithTag("AddButton").assertExists()
    }

    @Test
    fun test_addButton_isClickable() {
        composeTestRule.onNodeWithTag("AddButton").assertHasClickAction()
    }

    @Test
    fun test_addButton_backgroundColor_isTrue() {
        composeTestRule.onNodeWithTag("AddButton").assertColor(AddButton)
    }
}