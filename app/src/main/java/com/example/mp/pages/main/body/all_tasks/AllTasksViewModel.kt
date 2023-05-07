package com.example.mp.pages.main.body.all_tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mp.data.models.TaskDto
import com.example.mp.domain.TasksRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllTasksViewModel(private val repositoryImpl: TasksRepositoryImpl) :
    ViewModel() {


    var tasks = repositoryImpl.watchAllTasks()


    fun updateTask(i: Int, s: Boolean) {


        viewModelScope.launch(Dispatchers.IO) {
            val tasks = repositoryImpl.getAllTasks()

            val task: TaskDto = tasks[i].copy(
                status = s
            )

            repositoryImpl.updateTask(task)
        }


    }
}