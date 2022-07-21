package com.frnd.calendartasks.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.frnd.calendartasks.data.models.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM tasks WHERE date=:date")
    suspend fun getTask(date:Long):List<Task>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTask(task:Task)

    @Query("DELETE FROM tasks WHERE taskId=:taskId")
    suspend fun deleteTask(taskId:Int)
}