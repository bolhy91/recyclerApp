package com.bolhy91.recyclerapp.utils

import androidx.annotation.DrawableRes
import com.bolhy91.recyclerapp.R

data class Menu(val id: Int, val title: String, @DrawableRes val icon: Int, val url: String)

val menuItems: List<Menu> = listOf(
    Menu(1, "Notices", R.drawable.ic_home, "notices"),
    Menu(2, "Places", R.drawable.place, "places"),
    Menu(2, "Settings", R.drawable.menu, "settings"),
)