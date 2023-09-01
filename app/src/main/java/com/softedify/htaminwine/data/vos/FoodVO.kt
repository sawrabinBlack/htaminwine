package com.softedify.htaminwine.data.vos

import com.google.gson.annotations.SerializedName

data class FoodVO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("receipes")
    val receipes: List<String>,
    @SerializedName("nutrient")
    val nutrient: NutrientVO
)
