package com.softedify.htaminwine.data.vos

data class DateVO(
    val day : String,
    val weekDay : String,
    val date : String,
    var isSelected : Boolean = false
)