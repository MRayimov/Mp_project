package com.example.mp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mp.pages.main.MainScreen
import com.example.mp.ui.theme.MPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MPTheme {
                MainScreen()
            }
        }
    }


}
