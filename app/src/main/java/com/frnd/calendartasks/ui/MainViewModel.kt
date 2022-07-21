package com.frnd.calendartasks.ui

import androidx.lifecycle.ViewModel
import com.frnd.calendartasks.data.repositories.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val taskRepository: TaskRepository
):ViewModel() {

}