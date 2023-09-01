package com.softedify.htaminwine.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softedify.htaminwine.R
import com.softedify.htaminwine.delegate.MealDelegate
import com.softedify.htaminwine.viewholder.MealViewHolder

class MealAdapter(val isCategory : Boolean, val mealDelegate: MealDelegate): RecyclerView.Adapter<MealViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_food,parent,false)
        return MealViewHolder(view, mealDelegate,isCategory)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }
}