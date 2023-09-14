package com.example.categoryapp.repository

import com.example.categoryapp.api.TweetApi
import com.example.categoryapp.models.TweetList
import com.example.categoryapp.models.Tweets
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val tweetApi: TweetApi) {

    private val _category = MutableStateFlow<List<String>>(emptyList())
    val category: StateFlow<List<String>>
        get() = _category


    private val _tweets = MutableStateFlow<List<Tweets>>(emptyList())
    val tweet: StateFlow<List<Tweets>>
        get() = _tweets



     //contact -> sysnc -> update list of contact in contactList -> rahul
    //UI sceen  <- DATA viewmodel




    suspend fun getcategory() {
        val response = tweetApi.getCategory()
        if (response.isSuccessful && response.body() != null) {
            _category.emit(response.body()!!)
        }
    }













    suspend fun getTweets(category: String) {
        val response = tweetApi.getTweets("tweets[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body() !== null) {
            _tweets.emit(response.body()!!)
        }
    }
}