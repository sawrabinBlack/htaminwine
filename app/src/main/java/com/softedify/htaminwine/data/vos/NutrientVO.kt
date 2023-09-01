package com.softedify.htaminwine.data.vos

import com.google.gson.annotations.SerializedName

data class NutrientVO(
    @SerializedName("carbo")
    val carbo: Int?,
    @SerializedName("fat")
    val fat: Int?,
    @SerializedName("energy")
    val energy: Int?,
) {
}