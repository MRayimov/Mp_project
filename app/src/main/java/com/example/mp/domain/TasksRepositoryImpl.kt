package com.example.mp.domain

import androidx.lifecycle.LiveData
import com.example.mp.data.datasources.TasksDao
import com.example.mp.data.models.TaskDto

class TasksRepositoryImpl(private val tasksDao: TasksDao) :
    TasksRepository {

    override fun getAllTasks(): List<TaskDto> {
        return tasksDao.getAll()
    }

    override fun watchAllTasks(): LiveData<List<TaskDto>> {
        return tasksDao.watchAll()
    }

    override fun insertTask(taskDto: TaskDto) {
        tasksDao.insert(taskDto)
    }

    override fun updateTask(taskDto: TaskDto) {
        tasksDao.update(taskDto)
    }

}