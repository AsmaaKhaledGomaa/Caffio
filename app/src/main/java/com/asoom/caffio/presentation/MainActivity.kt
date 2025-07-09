package com.asoom.caffio.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.asoom.caffio.core.designSystem.theme.CaffioTheme
import com.asoom.caffio.di.viewModelModule
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaffioTheme {
                startKoin {
                    androidLogger()
                    modules(viewModelModule)
                }
                CaffioApp()
            }
        }
    }
}
