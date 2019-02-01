package com.example.borsh.addrecipe

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import com.example.borsh.R
import com.example.borsh.models.response.fridge.Ingredient
import kotlinx.android.synthetic.main.activity_add_recipe.*

const val FROM: String = "5c4edc01fc79b221b47f0d68"
class AddRecipeActivity : AppCompatActivity(), AddRecipeView {

    private val presenter = AddRecipePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        editNameRecipe.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                presenter.changeName(text.toString())
            }
        })

        createRecipebtn.setOnClickListener {
            presenter.createReceipt(
                editNameRecipe.text.toString(),
                FROM,
                listOf(
                spinner1.selectedItem as Ingredient
            ))

            presenter.createRecipe()
            finish()
        }

    }

    override fun onStart() {
        super.onStart()
        presenter.bindView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.unbindView()
    }

    override fun showIngredients(ingredientList: List<Ingredient>) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ingredientList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1.adapter = adapter
    }
}
