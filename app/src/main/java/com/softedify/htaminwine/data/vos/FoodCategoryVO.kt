package com.softedify.htaminwine.data.vos

import com.google.gson.annotations.SerializedName

data class FoodCategoryVO(
    @SerializedName("id")
    val id : Int,
    @SerializedName("name")
    val name : String?,
    @SerializedName("food")
    val food : List<FoodVO>?,
    @SerializedName("categoryImage")
    val categoryImage : String?
)
