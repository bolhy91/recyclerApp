package com.bolhy91.recyclerapp.ui.components
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bolhy91.recyclerapp.ui.theme.Purple200
import com.bolhy91.recyclerapp.ui.theme.Purple600
import com.bolhy91.recyclerapp.utils.Menu

@Composable
fun SectionMenuBottom(
    items: List<Menu>,
    selectedItemIndexMenu: MutableState<Int>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(Purple600)
    ) {
        items.forEachIndexed { index, menu ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(15.dp)
                    .clickable {
                        selectedItemIndexMenu.value = index
                        navController.navigate(menu.url)
                    }
            ) {
                Icon(
                    painter = painterResource(id = menu.icon),
                    contentDescription = menu.title + index,
                    tint = if (index == selectedItemIndexMenu.value) {
                        Color.White
                    } else {
                        Purple200
                    },
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = menu.title,
                    style = if (index == selectedItemIndexMenu.value) {
                        MaterialTheme.typography.subtitle2
                    } else {
                        MaterialTheme.typography.body1
                    },
                    color = Color.White,
                )
            }
        }
    }
}