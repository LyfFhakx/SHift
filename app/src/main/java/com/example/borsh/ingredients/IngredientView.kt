package com.example.borsh.ingredients

import com.example.borsh.models.response.contentrecipe.IngredientObj

interface IngredientView {
    fun showIngredient(ingredients: List<IngredientObj>)
}