package com.example.borsh.models.request

import com.google.gson.annotations.SerializedName

class SelectedIngredient(
    @SerializedName("ingredient") val ingredient: String,
    @SerializedName("plus") val plus: Int,
    @SerializedName("from") val from: String
)