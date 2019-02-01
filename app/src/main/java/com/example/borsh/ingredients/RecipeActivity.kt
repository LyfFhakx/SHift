package com.example.borsh.ingredients

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.example.borsh.R
import com.example.borsh.models.response.contentrecipe.IngredientObj

const val EXTRA_ID = "ID"
const val EXTRA_FROM = "FROM"
const val EXTRA_INGREDIENT = "INGREDIENT"

class RecipeActivity : AppCompatActivity(), IngredientView {

    private val presenter = IngredientListPresenter()
    private var adapter = IngredientAdapter(presenter::changeStatus)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        presenter.updateIngredient(intent.getStringExtra(EXTRA_ID))

        presenter.changeStatus(
            intent.getStringExtra(EXTRA_ID),
            intent.getStringExtra(EXTRA_INGREDIENT),
            1,
            intent.getStringExtra(EXTRA_FROM))

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Необходимые ингредиенты"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recipe_struct)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        presenter.bindView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.unbindView()
    }

    override fun showIngredient(ingredients: List<IngredientObj>) {
        adapter.setInstance(ingredients)
    }
}
