package com.frnd.calendartasks.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.frnd.calendartasks.data.models.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase() {
    abstract fun taskDao():TaskDao
}