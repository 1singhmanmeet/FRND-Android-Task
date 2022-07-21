package com.frnd.calendartasks.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @SerializedName("task_id")
    var taskId:Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("title")
    val title: String,
    val date:Long
)