package com.softedify.htaminwine.data.models

import android.content.Context
import com.softedify.htaminwine.persistence.HtaminWineDatabase

abstract class BaseModel() {

    protected var mLibraryDatabase: HtaminWineDatabase? = null
    fun initDatabase(context: Context) {
        mLibraryDatabase = HtaminWineDatabase.getDBStance(context)
    }
}