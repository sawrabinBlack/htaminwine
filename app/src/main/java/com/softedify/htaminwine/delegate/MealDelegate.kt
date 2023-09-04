package com.softedify.htaminwine.delegate

import com.softedify.htaminwine.data.vos.FoodVO

interface MealDelegate {

    fun tapOnCategory(foodlist : List<FoodVO>)
    fun tapOnItem(foodVO: FoodVO)
}