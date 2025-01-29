package com.prathamngundikere.rovervision

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.prathamngundikere.rovervision.core.presentation.MainScreen
import com.prathamngundikere.rovervision.ui.theme.RoverVisionTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoverVisionTheme {
                MainScreen()
            }
        }
    }
}