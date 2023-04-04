package com.example.hipolabschallange

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import com.example.hipolabschallange.ui.AddButton
import com.example.hipolabschallange.ui.theme.HipolabsChallangeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HipolabsChallangeTheme {
                AddButton(modifier = Modifier, text = "ADD NEW MEMBER")
            }
        }
    }
}