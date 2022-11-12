package com.bolhy91.recyclerapp.ui.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.activity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bolhy91.recyclerapp.pages.NoticeScreen
import com.bolhy91.recyclerapp.pages.PlaceScreen
import com.bolhy91.recyclerapp.pages.SettingScreen

@Composable
fun RecyclerNavGraph(navController: NavHostController, activity: Activity) {
    NavHost(
        navController = navController, startDestination = Destination.Notices.route
    ) {
        notices()
        places(activity)
        settings(activity)
    }
}

fun NavGraphBuilder.notices() {
    composable(route = Destination.Notices.route) {
        NoticeScreen()
    }
}

fun NavGraphBuilder.places(activity: Activity) {
    
    composable(route = Destination.Places.route) {
        PlaceScreen()
    }
}

fun NavGraphBuilder.settings(activity: Activity) {
    composable(route = Destination.Settings.route) {
        SettingScreen(activity)
    }
}