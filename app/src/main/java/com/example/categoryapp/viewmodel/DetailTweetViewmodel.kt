package com.example.categoryapp.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.categoryapp.models.Tweets
import com.example.categoryapp.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailTweetViewmodel @Inject constructor(
    private val repository: TweetRepository,
    private val saveStateHandel: SavedStateHandle
) : ViewModel() {
    val tweets: StateFlow<List<Tweets>>
        get() = repository.tweet


    init {
        viewModelScope.launch {
            val category = saveStateHandel.get<String>("category")
            repository.getTweets(category?:"android")
        }
    }
    /*  fun getTweets(category: String){
          viewModelScope.launch {
              repository.getTweets(category)
          }
      }*/
}