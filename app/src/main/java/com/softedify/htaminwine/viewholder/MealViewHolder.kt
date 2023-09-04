package com.softedify.htaminwine.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.softedify.htaminwine.data.vos.FoodCategoryVO
import com.softedify.htaminwine.data.vos.FoodVO
import com.softedify.htaminwine.delegate.MealDelegate

class MealViewHolder(itemView: View,val mealDelegate: MealDelegate,val isCategory: Boolean) : RecyclerView.ViewHolder(itemView) {

    init {

    }


    fun onBindCategory(categoryVO: FoodCategoryVO){
        itemView.setOnClickListener{
                mealDelegate.tapOnCategory(categoryVO.food?: listOf())

        }
    }


    fun onBindFood(foodVO: FoodVO){
        itemView.setOnClickListener{ mealDelegate.tapOnItem(foodVO)
        }
    }


}
