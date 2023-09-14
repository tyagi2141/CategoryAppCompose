package com.example.categoryapp.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.categoryapp.R
import com.example.categoryapp.viewmodel.TweetViewmodel

@Composable
fun CategoryScreen(onClick: (category: String) -> Unit) {


    val viewmodel: TweetViewmodel = hiltViewModel()


    val category: State<List<String>> = viewmodel.category.collectAsState()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
    ) {
        items(category.value.distinct()) {
            categoryItem(category = it, onClick)
        }
    }


}

@Composable
fun categoryItem(category: String, onClick: (categort: String) -> Unit) {

    Box(
        modifier = Modifier
            .clickable { onClick(category) }
            .size(160.dp)
            .padding(4.dp)
            .clip(RoundedCornerShape(8.dp))
            .paint(
                painter = painterResource(id = R.drawable.wave),
                contentScale = ContentScale.Crop
            )
            .border(1.dp, color = Color.LightGray), contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = category,
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier.padding(0.dp, 20.dp), style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showSystemUi = false)
@Composable
fun display() {
    categoryItem(category = "Android", {})
    // CategoryScreen({})
}