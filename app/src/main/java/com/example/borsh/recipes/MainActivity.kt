package com.example.borsh.recipes

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView

import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import com.example.borsh.fridge.FridgeActivity
import com.example.borsh.R
import com.example.borsh.addrecipe.AddRecipeActivity
import com.example.borsh.models.response.AddRecipe
import com.example.borsh.models.response.recipes.Recipe


class MainActivity : AppCompatActivity(), RecipeView {

    private var recipeList: MutableList<AddRecipe>? = null
    private val presenter = RecipeListPresenter()
    private val adapter = RVAdapter()
    private var searchView: SearchView? = null
    //lateinit var search: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = ""
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

       // search = findViewById(R.id.search)

        val recyclerView = findViewById<RecyclerView>(R.id.list_recipe)
        //recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val button = findViewById<Button>(R.id.add_recipe)
        button.setOnClickListener {
            val intent = Intent(this, AddRecipeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun showRecipe(recipes: List<AddRecipe>) {
        adapter.setPersons(recipes)
    }

    override fun onStart() {
        super.onStart()
        presenter.bindView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.unbindView()
    }

    @SuppressLint("ServiceCast")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

    //    val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
    //    searchView = menu?.findItem(R.id.action_search)
    //        ?.actionView as SearchView
    //    searchView!!.setSearchableInfo(searchManager
    //        .getSearchableInfo(componentName))
    //    searchView!!.maxWidth = Integer.MAX_VALUE
    //    // listening to search query text change
    //    searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
    //        override fun onQueryTextSubmit(query: String): Boolean {
    //            // filter recycler view when query submitted
    //            adapter.filter.filter(query)
    //            return false
    //        }
    //        override fun onQueryTextChange(query: String): Boolean {
    //            // filter recycler view when text is changed
    //            adapter.filter.filter(query)
    //            return false
    //        }
    //    })
          return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.fridge -> {
                startActivity(Intent(this@MainActivity, FridgeActivity::class.java))
                return true
            }
            R.id.action_search ->{
                return true
            }
        }
        return false
    }

    override fun onBackPressed() {
        // close search view on back button pressed
        if (!searchView!!.isIconified) {
            searchView!!.isIconified = true
            return
        }
        super.onBackPressed()
    }




}
