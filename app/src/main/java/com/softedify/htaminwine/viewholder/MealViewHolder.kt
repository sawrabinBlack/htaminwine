package com.softedify.htaminwine.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.softedify.htaminwine.delegate.MealDelegate

class MealViewHolder(itemView: View,val mealDelegate: MealDelegate,val isCategory: Boolean) : RecyclerView.ViewHolder(itemView) {

    init {
        itemView.setOnClickListener{
            if(isCategory){
                mealDelegate.tapOnCategory()
            } else mealDelegate.tapOnItem()
        }
    }


}
