package com.example.project.ui.taskAdd

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project.data.models.Task
import com.example.project.data.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskAddViewModel(private val repository: TaskRepository
) : ViewModel() {
    fun addTask(newTask: Task){
        viewModelScope.launch() {
            repository.addTask(newTask)}
    }
}