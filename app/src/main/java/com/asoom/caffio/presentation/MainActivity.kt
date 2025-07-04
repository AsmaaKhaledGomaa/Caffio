package com.asoom.caffio.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.asoom.caffio.presentation.navigation.CaffioNavGraph
import com.asoom.caffio.ui.theme.CaffioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaffioTheme {
                val navController = rememberNavController()
                CaffioNavGraph(navController)
            }
        }
    }
}
