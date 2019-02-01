package com.example.borsh.models.response.recipes

import com.example.borsh.models.response.fridge.Ingredient
import com.google.gson.annotations.SerializedName

class receipt (
    var name: String,
    var from: String,
    var ingredients: List<Ingredient>)

class addRecipe(@SerializedName("name") var name: String,
                @SerializedName("_id") val id: String,
                @SerializedName("ingredient") var ingredient: List<String>
)



