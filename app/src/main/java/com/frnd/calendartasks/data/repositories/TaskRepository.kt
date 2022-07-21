package com.frnd.calendartasks.data.repositories

import com.frnd.calendartasks.data.local.TaskDao
import com.frnd.calendartasks.data.models.Task
import com.frnd.calendartasks.data.remote.ApiService
import com.frnd.calendartasks.utils.Constants
import com.frnd.calendartasks.utils.SharedPreferenceManager
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val taskDao: TaskDao,
    private val apiService: ApiService,
    private val sharedPreferenceManager: SharedPreferenceManager
) {
    fun getTasks():List<Task>{
        val userId=sharedPreferenceManager.get(Constants.USER_ID)

    }
}