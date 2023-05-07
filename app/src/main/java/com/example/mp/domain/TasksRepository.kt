package com.example.mp.domain

import androidx.lifecycle.LiveData
import com.example.mp.data.models.TaskDto

interface TasksRepository {
    fun getAllTasks(): List<TaskDto>

    fun watchAllTasks(): LiveData<List<TaskDto>>

    fun insertTask(taskDto: TaskDto)

    fun updateTask(taskDto: TaskDto)
}