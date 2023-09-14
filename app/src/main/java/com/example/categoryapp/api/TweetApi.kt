package com.example.categoryapp.api

import com.example.categoryapp.models.TweetList
import com.example.categoryapp.models.Tweets
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetApi {

    @GET("v3/b/64f99ebe8d92e126ae684886?meta=false")
    suspend fun getTweets(@Header("X-Json-Path") category: String): Response<List<Tweets>>

    @GET("v3/b/64f99ebe8d92e126ae684886?meta=false")
    @Headers("X-Json-Path:tweets..category")
    suspend fun getCategory(): Response<List<String>>




}


//https://api.jsonbin.io/      v3/b/64f99ebe8d92e126ae684886?meta=false

//https://api.jsonbin.io/v3/b/64f99ebe8d92e126ae684886?meta=false