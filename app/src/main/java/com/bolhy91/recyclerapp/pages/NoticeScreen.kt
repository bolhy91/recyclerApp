package com.bolhy91.recyclerapp.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.bolhy91.recyclerapp.remote.NoticeListDto
import com.bolhy91.recyclerapp.ui.components.TopBarSection

@Composable
fun NoticeScreen(
    noticeViewModel: NoticeViewModel = hiltViewModel()
) {
    val state = noticeViewModel.state.value
    Column(
        modifier = Modifier.padding(
            start = 15.dp, top = 25.dp, bottom = 80.dp, end = 15.dp
        )
    ) {
        TopBarSection()
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Las Últimas noticias",
            modifier = Modifier.padding(bottom = 15.dp),
            style = MaterialTheme.typography.h1.copy(
                lineHeight = 35.sp
            ),
        )
        LazyColumn {
            items(state.products.size) { index ->
                CardItem(notice = state.products[index])
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
fun CardItem(notice: NoticeListDto) {
    Card(elevation = 4.dp, shape = RoundedCornerShape(20.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current).data(notice.banner)
                    .crossfade(true).build(),
                contentDescription = notice.name,
                modifier = Modifier.shadow(
                    0.dp, shape = RoundedCornerShape(10.dp), true
                ),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop
            )
        }
    }
}

