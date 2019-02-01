package com.example.borsh.fridge

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.widget.Toast
import com.example.borsh.R
import com.example.borsh.models.response.fridge.Foo

class FridgeActivity : AppCompatActivity(), FridgeView {

    private val presenter = FridgeListPresenter()
    private val adapter = FridgeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fridge)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Ингредиенты"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        val recyclerView = findViewById<RecyclerView>(R.id.ingredient_list)
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

    override fun showFridge(ingredients: List<Foo>) {
        adapter.setIngredient(ingredients)
    }

    override fun showBodyIsNullError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }
}
