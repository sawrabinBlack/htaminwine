package com.softedify.htaminwine.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softedify.htaminwine.R
import com.softedify.htaminwine.data.vos.FoodCategoryVO
import com.softedify.htaminwine.data.vos.FoodVO
import com.softedify.htaminwine.delegate.MealDelegate
import com.softedify.htaminwine.viewholder.MealViewHolder
import java.util.Locale.Category

class MealAdapter(val isCategory: Boolean, val mealDelegate: MealDelegate) :
    RecyclerView.Adapter<MealViewHolder>() {

    var FoodCategoryList: List<FoodCategoryVO> = listOf()
    var FoodList: List<FoodVO> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_food, parent, false)
        return MealViewHolder(view, mealDelegate, isCategory)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        if (isCategory) {

            holder.onBindCategory(FoodCategoryList[position])
        } else {
            holder.onBindFood(FoodList[position])
        }
    }

    override fun getItemCount(): Int {

        return if (isCategory) {
            FoodCategoryList.count()
        } else FoodList.count()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setCategory(categoryList: List<FoodCategoryVO>) {
        FoodCategoryList = categoryList
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setFood(foodList: List<FoodVO>) {
        FoodList = foodList
        notifyDataSetChanged()
    }
}