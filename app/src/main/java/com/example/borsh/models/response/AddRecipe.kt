package com.example.borsh.models.response

import com.google.gson.annotations.SerializedName

class AddRecipe (
    @SerializedName("name") var name: String,
    @SerializedName("_id") val id: String,
    @SerializedName("ingredient") var ingredient: List<String>,
    @SerializedName("from") val from: From,
    @SerializedName("done") val done: Boolean)

class From(val name: String, val room: Int)