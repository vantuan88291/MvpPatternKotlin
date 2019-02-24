package com.tuan88291.mvppatternkotlin.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tuan88291.mvppatternkotlin.data.entity.DataRoom

@Dao
interface QueriesDao {

    @get:Query("select * from user")
    val all: LiveData<List<DataRoom>>

    @Insert
    fun insertData(item: DataRoom)
}