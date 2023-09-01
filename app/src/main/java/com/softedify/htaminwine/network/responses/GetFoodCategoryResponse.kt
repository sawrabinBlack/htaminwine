package com.softedify.htaminwine.network.responses

import com.google.gson.annotations.SerializedName
import com.softedify.htaminwine.data.vos.FoodCategoryVO

data class GetFoodCategoryResponse(
    @SerializedName("category")
    var category: List<FoodCategoryVO>
) {
}