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
                description = "The recipe here is for cooking on the stove, but you can just easily use a slow cooker. It’s worry-free, and easier to manage. You won’t need to watch the pot and monitor the braising liquid like you would cooking on the stove.",
                receipes = listOf(),
                nutrient = NutrientVO(
                    carbo = 10, fat = 10, energy = 100, protein = 20
                ),
                foodImage = "https://images.unsplash.com/photo-1546069901-ba9599a7e63c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2980&q=80"
            ),
            FoodVO(
                id = 2,
                name = "ဝက်သားဟင်း",
                description = "The recipe here is for cooking on the stove, but you can just easily use a slow cooker. It’s worry-free, and easier to manage. You won’t need to watch the pot and monitor the braising liquid like you would cooking on the stove.",
                receipes = listOf(),
                nutrient = NutrientVO(
                    carbo = 10, fat = 10, energy = 100, protein = 20
                ),
                foodImage = "https://static01.nyt.com/images/2019/12/13/dining/mc-beef-wellington/mc-beef-wellington-master768-v2.jpg?w=1280&q=75"
            ),

        ),
        categoryImage = "https://www.whiskaffair.com/wp-content/uploads/2021/10/Andhra-Chicken-Curry-2-1.jpg"
    )

)