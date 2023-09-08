package com.example.categoryapp.models

import com.google.gson.annotations.SerializedName

data class TweetList(
    @SerializedName("tweets" ) var tweets : ArrayList<Tweets> = arrayListOf()
)
