package com.softedify.htaminwine.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.softedify.htaminwine.data.vos.DailyRecordVO
import com.softedify.htaminwine.persistence.daos.DailyRecordDao
@Database(
    entities =[DailyRecordVO::class], exportSchema = false, version = 1
)
abstract class HtaminWineDatabase : RoomDatabase() {
    companion object {
        private const val DB_NAME = "HTA_MIN_WINE_DB"
        var dbInstance: HtaminWineDatabase? = null
        fun getDBStance(context: Context): HtaminWineDatabase? {
            when (dbInstance) {
                null -> {
                    dbInstance =
                        Room.databaseBuilder(context, HtaminWineDatabase::class.java, DB_NAME)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration().build()
                }
            }
            return dbInstance
        }
    }

    abstract fun dailyRecordDao() : DailyRecordDao
}