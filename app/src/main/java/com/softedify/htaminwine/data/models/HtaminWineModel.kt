package com.softedify.htaminwine.data.models

import androidx.lifecycle.LiveData
import com.softedify.htaminwine.data.vos.DailyRecordVO
import com.softedify.htaminwine.data.vos.FoodVO
import com.softedify.htaminwine.persistence.daos.DailyRecordDao
import java.util.Date

interface HtaminWineModel {
    fun updateWater(water : Int,date: String)
    fun getDailyRecordByDate(date: String) : LiveData<DailyRecordVO?>?
    fun updateExercise(workout : Int,date: String)
    fun updateFood(food: FoodVO,date: String)
    fun createNewDailyRecord(date: String)
}