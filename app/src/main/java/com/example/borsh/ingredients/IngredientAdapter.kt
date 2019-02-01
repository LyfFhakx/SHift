package com.example.borsh.ingredients

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.borsh.R
import com.example.borsh.models.response.contentrecipe.IngredientObj
import kotlinx.android.synthetic.main.struct_recipe_item.view.*

class IngredientAdapter(
    private val onStatusChanged: (id: String, ingredientId: String, plus: Int, from: String) -> Unit
) : RecyclerView.Adapter<IngredientHolder>() {

    private val ingredients: MutableList<IngredientObj> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): IngredientHolder =
        IngredientHolder(LayoutInflater.from(parent.context).inflate(R.layout.struct_recipe_item, parent, false), onStatusChanged)

    override fun getItemCount(): Int = ingredients.size

    override fun onBindViewHolder(holder: IngredientHolder, position: Int) {
        holder.bind(ingredients[position])
    }

    fun setInstance(ingredients: List<IngredientObj>) {
        this.ingredients.clear()
        this.ingredients.addAll(ingredients)
        notifyDataSetChanged()
    }
}

class IngredientHolder(
    view: View,
    private val onStatusChanged: (id: String, ingredientId: String, plus: Int, from: String) -> Unit
) : RecyclerView.ViewHolder(view) {

    fun bind(title: IngredientObj) {
        itemView.title_ingredient.text = title.ingredient.name
        itemView.check_item.isChecked = title.done
        //itemView.title_ingredient.text = title.ingredient._id

        itemView.check_item.setOnCheckedChangeListener { _, _ ->
            onStatusChanged(title.ingredient._id, )
        }
    }
}