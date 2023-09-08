package com.example.categoryapp.models

import com.google.gson.annotations.SerializedName



data class Tweets(
    @SerializedName("text") var text: String? = null,
    @SerializedName("category") var category: String? = null
)
