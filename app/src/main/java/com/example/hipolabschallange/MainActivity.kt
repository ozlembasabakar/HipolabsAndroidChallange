package com.example.hipolabschallange

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.hipolabschallange.feature.membersScreen.MembersScreen
import com.example.hipolabschallange.designsystem.theme.HipolabsChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HipolabsChallengeTheme {
                MembersScreen()
            }
        }
    }
}