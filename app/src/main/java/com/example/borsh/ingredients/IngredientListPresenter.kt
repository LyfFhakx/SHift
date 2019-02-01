package com.example.borsh.ingredients

import android.util.Log
import com.example.borsh.App
import com.example.borsh.models.request.SelectedIngredient
import com.example.borsh.models.response.contentrecipe.BaseResponse
import com.example.borsh.models.response.contentrecipe.ContentRecipe
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IngredientListPresenter {

    private var view: IngredientView? = null

    fun bindView(view: IngredientView) {
        this.view = view
    }

    fun updateIngredient(id: String) {
        App.api
            .getStructRecipe(id)
            .enqueue(object : Callback<BaseResponse<ContentRecipe>> {
                override fun onFailure(call: Call<BaseResponse<ContentRecipe>>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<BaseResponse<ContentRecipe>>,
                    response: Response<BaseResponse<ContentRecipe>>
                ) {
                    val ingredients = response.body()?.content?.ingredients

                    Log.i("Recipe struct = ", ingredients.toString())
                    Log.i("STATUS = ", response.code().toString())

                    if (ingredients != null) {
                        view?.showIngredient(ingredients)
                    }
                }

            })
    }

    fun changeStatus(id: String, idIngredient: String, plus: Int , from: String) {
        App.api
            .changeStatus(id, SelectedIngredient(idIngredient, plus, from))
            .enqueue(object : Callback<BaseResponse<ContentRecipe>> {
                override fun onFailure(call: Call<BaseResponse<ContentRecipe>>, t: Throwable) {
                }

                override fun onResponse(
                    call: Call<BaseResponse<ContentRecipe>>,
                    response: Response<BaseResponse<ContentRecipe>>
                ) {

                }

            })
    }

    fun unbindView() {
        this.view = null
    }
}