package com.tuan88291.mvppatternkotlin.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class DataRoom {

    @PrimaryKey(autoGenerate = true)
    var mId: Long = 0

    @ColumnInfo(name = "name")
    var name: String? = null


    @ColumnInfo(name = "age")
    var age: Int = 0

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    constructor() {}

    fun getmId(): Long {
        return mId
    }

    fun setmId(mId: Long) {
        this.mId = mId
    }
}