package com.bolhy91.recyclerapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.bolhy91.recyclerapp.ui.components.BaseLayoutScreen
import com.bolhy91.recyclerapp.ui.navigation.RecyclerNavGraph
import com.bolhy91.recyclerapp.ui.theme.RecyclerAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecyclerAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    val selectedItemIndexMenu = remember { mutableStateOf(0) }

                    BaseLayoutScreen(
                        navController = navController, selectedItemIndexMenu = selectedItemIndexMenu
                    ) {
                        RecyclerNavGraph(
                            navController = navController, activity = this@MainActivity
                        )
                    }
                }
            }
        }
    }
}