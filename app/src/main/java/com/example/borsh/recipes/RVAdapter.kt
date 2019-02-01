package com.example.borsh.recipes

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import com.example.borsh.R
import com.example.borsh.ingredients.EXTRA_FROM
import com.example.borsh.ingredients.EXTRA_ID
import com.example.borsh.ingredients.EXTRA_INGREDIENT
import com.example.borsh.ingredients.RecipeActivity
import com.example.borsh.models.response.AddRecipe
import com.example.borsh.models.response.recipes.Recipe
import kotlinx.android.synthetic.main.item.view.*

class RVAdapter: RecyclerView.Adapter<RecipeHolder>() {

    private var recipes: MutableList<AddRecipe> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder =
        RecipeHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item,
                parent,
                false
            )
        )

    override fun getItemCount(): Int {
        return recipes.size
    }

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        holder.bind(recipes[position])
    }

    fun setPersons(recipe: List<AddRecipe>) {
        this.recipes.clear()
        this.recipes.addAll(recipe)
        notifyDataSetChanged()
    }

   // override fun getFilter(): Filter {
   //     return object : Filter() {
   //         override fun performFiltering(charSequence: CharSequence): Filter.FilterResults {
   //             val charString = charSequence.toString()
   //             if (charString.isEmpty()) {
   //                 recipes = recipeList
   //             } else {
   //                 val filteredList = ArrayList<AddRecipe>()
   //                 for (row in recipeList) {
   //                     if (row.name.toLowerCase().contains(charString.toLowerCase())) {
   //                         filteredList.add(row)
   //                     }
   //                 }
   //                 recipes = filteredList
   //             }
   //             val filterResults = Filter.FilterResults()
   //             filterResults.values = recipes
   //             return filterResults
   //         }
   //         override fun publishResults(charSequence: CharSequence, filterResults: Filter.FilterResults) {
   //             recipes = filterResults.values as ArrayList<AddRecipe>
   //             notifyDataSetChanged()
   //         }
   //     }
   // }

}

class RecipeHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var id: String = ""
    private var from: String = ""
    private var ingredientId: String = ""

    fun bind(recipe: AddRecipe) {
        itemView.title_recipe.text = recipe.name
       // itemView.title_name.text = recipe.from.name
       // itemView.title_room.text = recipe.from.room.toString()
        itemView.recipe_check.isChecked = recipe.done
        id = recipe.id
        from = recipe.from.name
        ingredientId = recipe.ingredient.toString()
    }

    init {
        itemView.setOnClickListener {
            val recipeIntent = Intent(itemView.context, RecipeActivity::class.java)
            recipeIntent.putExtra(EXTRA_ID, id)
            recipeIntent.putExtra(EXTRA_FROM, from)
            recipeIntent.putExtra(EXTRA_INGREDIENT, ingredientId)
            itemView.context.startActivity(recipeIntent)
        }
    }
}