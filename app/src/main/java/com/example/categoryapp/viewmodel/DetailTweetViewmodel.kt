package com.example.categoryapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.categoryapp.models.TweetList
import com.example.categoryapp.models.Tweets
import com.example.categoryapp.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailTweetViewmodel @Inject constructor(private val repository: TweetRepository) : ViewModel() {
    val tweets: StateFlow<List<Tweets>>
        get() = repository.tweet
    

    init {
        viewModelScope.launch {
            repository.getTweets("android")
        }
    }
}