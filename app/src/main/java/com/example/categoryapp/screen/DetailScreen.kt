package com.example.categoryapp.screen

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.categoryapp.viewmodel.DetailTweetViewmodel

//import androidx.compose.foundation.lazy.items

@Composable
fun DetailScreen(category: String) {
    val viewmodel: DetailTweetViewmodel = hiltViewModel()
    val result = viewmodel.tweets.collectAsState()
    Log.e("jhjhjkh", "${result.value.map { it }}")

    LazyColumn() {
        items(result.value) {
            TweetListItem(tweet = it.text ?: "NA")
        }
    }


}


@Composable
fun TweetListItem(tweet: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .padding(5.dp)
            .background(Color.White)
            .border(border = BorderStroke(1.dp, Color.LightGray))
    ) {
        Text(
            text = tweet,
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun show() {
    TweetListItem("hello")
}