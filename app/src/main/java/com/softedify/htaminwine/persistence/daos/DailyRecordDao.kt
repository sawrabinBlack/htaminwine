package com.softedify.htaminwine.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.softedify.htaminwine.data.vos.DailyRecordVO

@Dao
interface DailyRecordDao {

    @Query("SELECT * FROM dailyRecord WHERE date=:date")
    fun getRecordByDateLiveData(date: String): LiveData<DailyRecordVO?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleRecord(dailyRecord: DailyRecordVO)

    @Query("SELECT * FROM dailyRecord WHERE date=:date")
    fun getRecordByDate(date: String): DailyRecordVO?
}