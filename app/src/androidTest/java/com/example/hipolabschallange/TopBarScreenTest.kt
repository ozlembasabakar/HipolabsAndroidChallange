package com.example.hipolabschallange

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.hipolabschallange.designsystem.theme.TopBarTextColorAlpha
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TopBarScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun test_topBar_isVisible() {
        composeTestRule.onNodeWithTag("TopBar").assertExists()
    }

    @Test
    fun test_topBarText_isVisible() {
        composeTestRule.onNodeWithTag("TopBarText").assertExists()
    }

    @Test
    fun test_addButton_topBarColor_isTrue() {
        composeTestRule.onNodeWithTag("TopBar").assertColor(Color.White)
    }

    @Test
    fun test_addButton_topBarTextColor_isTrue() {
        composeTestRule.onNodeWithTag("TopBarText").assertColor(Color.Black.copy(alpha = TopBarTextColorAlpha))
    }
}