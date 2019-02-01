package com.example.borsh.models.response.recipes

import com.google.gson.annotations.SerializedName

class Recipe(
    @SerializedName("name") var name: String,
    @SerializedName("_id") val id: String,
    @SerializedName("ingredient") var ingredient: List<String>
    //@SerializedName("from") val from: From
    )

//class From(val name: String, val room: Int)
