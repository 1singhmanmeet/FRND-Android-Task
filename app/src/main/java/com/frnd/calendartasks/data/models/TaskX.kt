package com.frnd.calendartasks.data.models

import com.google.gson.annotations.SerializedName

data class TaskX(
    @SerializedName("task_detail")
    val taskDetail: TaskDetail,
    @SerializedName("task_id")
    val taskId: Int
)