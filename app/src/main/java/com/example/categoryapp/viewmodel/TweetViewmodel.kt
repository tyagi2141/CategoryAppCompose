package com.example.categoryapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.categoryapp.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TweetViewmodel @Inject constructor(private val repository: TweetRepository) : ViewModel() {
    val category: StateFlow<List<String>>
        get() = repository.category



    init {

        viewModelScope.launch {
            repository.getcategory()
        }


      /*  viewModelScope.launch {
            repository.getcategory()
        }*/
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("viewmodel ","is cleare")
    }
}