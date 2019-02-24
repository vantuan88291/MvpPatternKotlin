package com.tuan88291.mvppatternkotlin.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tuan88291.mvppatternkotlin.data.entity.DataRoom

@Database(entities = [DataRoom::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun queries(): QueriesDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "user-database")
                    .build()
            }
            return INSTANCE as AppDatabase
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
