package com.example.borsh.fridge

import com.example.borsh.models.response.fridge.Foo


interface FridgeView {
    fun showFridge(ingredients: List<Foo>)
    fun showBodyIsNullError()
}