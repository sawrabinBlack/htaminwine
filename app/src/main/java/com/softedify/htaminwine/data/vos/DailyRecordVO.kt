package com.softedify.htaminwine.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dailyRecord")
data class DailyRecordVO(
    @PrimaryKey
    val date : String,
    @ColumnInfo
    var water : Int = 0,
    @ColumnInfo
    var workout : Int = 0,
    @ColumnInfo
    var calories : Int = 0,
    @ColumnInfo
    var carbos : Int = 0,
    @ColumnInfo
    var protein : Int = 0,
    @ColumnInfo
    var fat: Int = 0
)
