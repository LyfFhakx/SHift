package com.example.borsh.addrecipe

import com.example.borsh.App
import com.example.borsh.models.response.AllIngredientResponse
import com.example.borsh.models.response.contentrecipe.IngredientObj
import com.example.borsh.models.response.recipes.Recipe
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddRecipePresenter {

    private val recipe: Recipe = Recipe("","", mutableListOf())
    private var view: AddRecipeView? = null

    fun bindView(view: AddRecipeView) {
        this.view = view
        updateAddRecipe()
    }

    private fun updateAddRecipe() {
        App.api
            .getAllIngredients()
            .enqueue(object : Callback<AllIngredientResponse> {
                override fun onFailure(call: Call<AllIngredientResponse>, t: Throwable) {}

                override fun onResponse(
                    call: Call<AllIngredientResponse>,
                    response: Response<AllIngredientResponse>
                ) {
                    val ingredients = response.body()?.content?.map { it.name }

                    if (ingredients != null)
                        view?.showIngredients(ingredients)
                }
            })
    }

     fun createRecipe(){
        App.api
            .addRecipe(recipe.name, recipe.ingredient)
            .enqueue(object : Callback<IngredientObj>{
                override fun onFailure(call: Call<IngredientObj>, t: Throwable) {
                }

                override fun onResponse(call: Call<IngredientObj>, response: Response<IngredientObj>) {

                }

            })
    }

    fun changeName(name: String) {
        recipe.name = name
    }

    fun createReceipt(ingredientList: List<String>) {
        recipe.ingredient = ingredientList
    }

    fun unbindView() {
        this.view = null
    }
}