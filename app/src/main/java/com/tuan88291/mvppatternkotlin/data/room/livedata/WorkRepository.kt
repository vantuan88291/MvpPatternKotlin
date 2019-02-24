package com.tuan88291.mvppatternkotlin.data.room.livedata

import android.app.Application
import androidx.lifecycle.LiveData
import com.tuan88291.mvppatternkotlin.data.entity.DataRoom
import com.tuan88291.mvppatternkotlin.data.room.AppDatabase
import com.tuan88291.mvppatternkotlin.data.room.QueriesDao
import easy.asyntask.tuan88291.library.AsyncTaskEasy

class WorkRepository internal constructor(application: Application) {
    private val mQueries: QueriesDao
    internal val allData: LiveData<List<DataRoom>>

    init {
        val db = AppDatabase.getAppDatabase(application)
        mQueries = db.queries()
        allData = mQueries.all
    }


    fun insert(data: DataRoom) {
        object : AsyncTaskEasy() {
            override fun doBackground(): Any? {
                mQueries.insertData(data)
                return null
            }
        }
    }
}
