package com.frnd.calendartasks.data.models

import com.google.gson.annotations.SerializedName

data class DeleteTaskRequest(
    @SerializedName("task_id")
    val taskId: Int,
    @SerializedName("user_id")
    val userId: Int
)