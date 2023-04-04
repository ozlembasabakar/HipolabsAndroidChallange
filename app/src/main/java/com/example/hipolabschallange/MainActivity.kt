package com.example.hipolabschallange

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.hipolabschallange.ui.MainScreen
import com.example.hipolabschallange.ui.theme.HipolabsChallangeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HipolabsChallangeTheme {
                MainScreen()
            }
        }
    }
}