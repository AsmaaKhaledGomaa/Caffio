package com.asoom.caffio.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.asoom.caffio.presentation.home.HomeScreen
import com.asoom.caffio.core.designSystem.theme.CaffioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaffioTheme {
                HomeScreen()
            }
        }
    }
}
