package com.example.borsh.models.request

import com.example.borsh.models.response.fridge.Ingredient
import com.google.gson.annotations.SerializedName

class NewRecipeRequest(
    @SerializedName("name") var name: String,
    @SerializedName("from") var from: UserId?,
    @SerializedName("ingredients") var ingredient: List<Ingredient> ) {
}
class UserId(name: String, room: Int)


