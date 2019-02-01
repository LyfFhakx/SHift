package com.example.borsh.fridge

import android.util.Log
import com.example.borsh.App
import com.example.borsh.models.response.fridge.IngredientResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FridgeListPresenter {

    private var view: FridgeView? = null

    fun bindView(view: FridgeView){
        this.view = view
        updateIngredient()
    }

    private fun updateIngredient(){
        App.api
            .getAllIngredient()
            .enqueue(object : Callback<IngredientResponse>{
                override fun onFailure(call: Call<IngredientResponse>, t: Throwable) {

                }

                override fun onResponse(call: Call<IngredientResponse>, response: Response<IngredientResponse>) {
                    val ingredients = response.body()?.content?.fridge

                    Log.i("Ingredients = ", ingredients.toString())
                    Log.i("STATUS = ", response.code().toString())

                    if(ingredients != null){
                        view?.showFridge(ingredients)
                    }
                }

            })
    }

    fun unbindView(){
        this.view = null
    }
}