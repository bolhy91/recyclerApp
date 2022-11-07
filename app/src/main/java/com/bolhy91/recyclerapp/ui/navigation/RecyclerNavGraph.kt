package com.bolhy91.recyclerapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bolhy91.recyclerapp.pages.NoticeScreen
import com.bolhy91.recyclerapp.pages.PlaceScreen
import com.bolhy91.recyclerapp.pages.SettingScreen

@Composable
fun RecyclerNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = Destination.Notices.route
    ) {
        notices()
        places()
        settings()
    }
}

fun NavGraphBuilder.notices() {
    composable(route = Destination.Notices.route) {
        NoticeScreen()
    }
}

fun NavGraphBuilder.places() {
    composable(route = Destination.Places.route) {
        PlaceScreen()
    }
}

fun NavGraphBuilder.settings() {
    composable(route = Destination.Settings.route) {
        SettingScreen()
    }
}