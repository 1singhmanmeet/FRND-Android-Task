package com.frnd.calendartasks.data.remote

import com.frnd.calendartasks.data.models.*
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("getCalendarTaskList")
    suspend fun storeTask(@Body storeTaskRequest:StoreTaskRequest):TaskResponse

    @POST("getCalendarTaskList")
    suspend fun getTasks(@Body getTasksRequest: GetTasksRequest):List<Task>

    @POST("deleteCalendarTask")
    suspend fun deleteTask(@Body deleteTaskRequest: DeleteTaskRequest):TaskResponse
}