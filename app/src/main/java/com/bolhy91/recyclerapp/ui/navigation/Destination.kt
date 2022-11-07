package com.bolhy91.recyclerapp.ui.navigation

import androidx.navigation.NamedNavArgument

sealed class Destination(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    object Notices : Destination("notices")
    object Places : Destination("places")
    object Settings : Destination("settings")
}