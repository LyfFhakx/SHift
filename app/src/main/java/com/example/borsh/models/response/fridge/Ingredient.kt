package com.example.borsh.models.response.fridge

import com.google.gson.annotations.SerializedName

class Ingredient (

    @SerializedName("_id") val id: String,
    @SerializedName( "name") val name: String,
    @SerializedName("unit") val unit: String
) {

   override fun toString(): String = name
}