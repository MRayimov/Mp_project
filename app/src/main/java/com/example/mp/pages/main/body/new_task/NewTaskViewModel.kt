package com.example.mp.pages.main.body.new_task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mp.data.models.TaskDto
import com.example.mp.domain.TasksRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NewTaskViewModel(
    private val repositoryImpl: TasksRepositoryImpl
) : ViewModel() {

    private val _text = MutableStateFlow("")
    val text: StateFlow<String> = _text.asStateFlow()


    fun onTextChange(t: String) {
        _text.value = t
    }

    fun onSubmit() {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryImpl.insertTask(
                TaskDto(
                    name = text.value,
                    status = false,
                    id = 0 // we put id 0, but it will be auto generated
                )
            )
        }

    }
}