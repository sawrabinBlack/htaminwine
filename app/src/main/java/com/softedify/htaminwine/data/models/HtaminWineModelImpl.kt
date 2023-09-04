package com.softedify.htaminwine.data.models

import androidx.lifecycle.LiveData
import com.softedify.htaminwine.data.vos.DailyRecordVO
import com.softedify.htaminwine.data.vos.FoodVO
import java.util.Date

object HtaminWineModelImpl : HtaminWineModel, BaseModel() {
    override fun updateWater(water: Int, date: String) {
        var dailyRecord = mLibraryDatabase?.dailyRecordDao()?.getRecordByDate(date)
        if (dailyRecord == null) {
            val dailyRecordVO = DailyRecordVO(date = date, water = water)
            mLibraryDatabase?.dailyRecordDao()?.insertSingleRecord(dailyRecordVO)
        } else {
            dailyRecord.water += water
            mLibraryDatabase?.dailyRecordDao()?.insertSingleRecord(dailyRecord)
        }
    }

    override fun getDailyRecordByDate(date: String): LiveData<DailyRecordVO?>? {
        return mLibraryDatabase?.dailyRecordDao()?.getRecordByDateLiveData(date)
    }

    override fun updateExercise(workout: Int, date: String) {
        val dailyRecord = mLibraryDatabase?.dailyRecordDao()?.getRecordByDate(date)
        dailyRecord?.let {
            it.workout += workout
            mLibraryDatabase?.dailyRecordDao()?.insertSingleRecord(it)
        }

    }

    override fun updateFood(food: FoodVO, date: String) {
        val dailyRecord = mLibraryDatabase?.dailyRecordDao()?.getRecordByDate(date)
        dailyRecord?.let {
            it.calories += food.nutrient?.energy ?: 0
            mLibraryDatabase?.dailyRecordDao()?.insertSingleRecord(it)
        }
    }

    override fun createNewDailyRecord(date: String) {
        var dailyRecord = mLibraryDatabase?.dailyRecordDao()?.getRecordByDate(date)
        if (dailyRecord == null) {
            val dailyRecordVO = DailyRecordVO(date = date)
            mLibraryDatabase?.dailyRecordDao()?.insertSingleRecord(dailyRecordVO)
        }
    }
}