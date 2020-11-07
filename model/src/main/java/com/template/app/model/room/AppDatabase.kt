package com.template.app.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.template.app.model.entities.Data
import com.template.app.model.room.dao.DataDao

@Database(
    entities = [
        Data::class,
    ],
    version = 1
)
//@TypeConverters(RoomTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val dataDao: DataDao

    companion object {
        private const val DB_NAME = "projects.db"
        private var appDatabase: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (appDatabase == null) {
                appDatabase = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DB_NAME
                ).build()
            }
            return appDatabase as AppDatabase
        }
    }
}