package com.softedify.htaminwine.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softedify.htaminwine.R
import com.softedify.htaminwine.data.vos.FoodCategoryVO
import com.softedify.htaminwine.data.vos.FoodVO
import com.softedify.htaminwine.delegate.MealDelegate

class MealViewHolder(itemView: View, val mealDelegate: MealDelegate, val isCategory: Boolean) :
    RecyclerView.ViewHolder(itemView) {
    lateinit var foodImage: ImageView




    fun onBindCategory(categoryVO: FoodCategoryVO) {
        foodImage = itemView.findViewById(R.id.ivMealCategory)
        var foodText = itemView.findViewById<TextView>(R.id.tvMealViewHolder)


        itemView.setOnClickListener {
            mealDelegate.tapOnCategory(categoryVO.food ?: listOf())

        }
        Glide.with(itemView.context).load(categoryVO.categoryImage?:"").into(foodImage)
        foodText.text = categoryVO.name

    }


    fun onBindFood(foodVO: FoodVO) {
        foodImage = itemView.findViewById(R.id.ivMealCategory)
        var foodText = itemView.findViewById<TextView>(R.id.tvMealViewHolder)
        itemView.setOnClickListener {
            mealDelegate.tapOnItem(foodVO)
        }

        Glide.with(itemView.context).load(foodVO.foodImage?:"").into(foodImage)
        foodText.text = foodVO.name
    }


}
