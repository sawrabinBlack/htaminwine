package com.softedify.htaminwine.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softedify.htaminwine.R
import com.softedify.htaminwine.viewholder.MealIngredientsViewHolder

class MealIngredientsAdapter : RecyclerView.Adapter<MealIngredientsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealIngredientsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_meal_ingredients, parent, false)

        return MealIngredientsViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealIngredientsViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
       return  10
    }
}