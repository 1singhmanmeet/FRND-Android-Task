package com.frnd.calendartasks.data.models

import com.google.gson.annotations.SerializedName

data class StoreTaskRequest(
    @SerializedName("task")
    val task: Task,
    @SerializedName("user_id")
    val userId: Int
)