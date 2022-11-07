package com.bolhy91.recyclerapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.bolhy91.recyclerapp.utils.menuItems

@Composable
fun BaseLayoutScreen(
    navController: NavHostController,
    selectedItemIndexMenu: MutableState<Int>,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        content()
        SectionMenuBottom(
            items = menuItems,
            modifier = Modifier.align(Alignment.BottomCenter),
            navController = navController,
            selectedItemIndexMenu = selectedItemIndexMenu
        )
    }
}