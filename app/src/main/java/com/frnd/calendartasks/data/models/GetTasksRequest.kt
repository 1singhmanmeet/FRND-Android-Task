package com.frnd.calendartasks.data.models

import com.google.gson.annotations.SerializedName

data class GetTasksRequest(
    @SerializedName("user_id")
    val userId: Int
)