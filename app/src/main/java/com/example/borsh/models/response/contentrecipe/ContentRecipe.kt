package com.example.borsh.models.response.contentrecipe

class ContentRecipe(val ingredients: List<IngredientObj>)

class IngredientObj(val done: Boolean ,val ingredient: IngredientName)