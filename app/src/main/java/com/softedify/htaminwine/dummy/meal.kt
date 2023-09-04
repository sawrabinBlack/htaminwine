package com.softedify.htaminwine.dummy

import com.softedify.htaminwine.data.vos.FoodCategoryVO
import com.softedify.htaminwine.data.vos.FoodVO
import com.softedify.htaminwine.data.vos.NutrientVO


val meals = listOf<FoodCategoryVO>(

    FoodCategoryVO(
        id = 1,
        name = "မြန်မာဟင်း",
        food = listOf(
            FoodVO(
                id = 1,
                name = "ကြက်သားကြော်",
                description = "",
                receipes = listOf(),
                nutrient = NutrientVO(
                    carbo = 10, fat = 10, energy = 100
                ),
                foodImage = "https://images.unsplash.com/photo-1546069901-ba9599a7e63c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2980&q=80"
            )
        ),
        categoryImage = "https://www.whiskaffair.com/wp-content/uploads/2021/10/Andhra-Chicken-Curry-2-1.jpg"
    )

)