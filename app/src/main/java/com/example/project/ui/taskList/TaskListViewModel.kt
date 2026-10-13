package com.example.project.ui.taskList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project.data.models.Task
import com.example.project.data.repository.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TaskListViewModel(
    private val repository : TaskRepository = TaskRepository()
) : ViewModel() {
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks : StateFlow<List<Task>> = _tasks

    private val _task = MutableStateFlow<Task?>(null)
    val task : StateFlow<Task?> = _task

    private var _showAddDialog = MutableStateFlow(false)
    val showAddDialog: StateFlow<Boolean> = _showAddDialog

    private var _showDeleteDialog = MutableStateFlow(false)
    val showDeleteDialog: StateFlow<Boolean> = _showDeleteDialog

    private var _showUpdateDialog = MutableStateFlow(false)
    val showUpdateDialog: StateFlow<Boolean> = _showUpdateDialog

    init {
        loadTask()
    }

    //загрузка
    fun loadTask(){
        viewModelScope.launch {
            _tasks.value = repository.getAllTasks()
        }
    }

    //создание новой
    fun addTask(newTask: Task) {
        viewModelScope.launch {
            repository.addTask(newTask)
            loadTask()
            hideAddDialog()
        }
    }

    //получение
    fun SelectTask(task: Task){
        _task.value = task
    }

    //удаление
    fun deleteTask(){
        viewModelScope.launch {
            repository.deleteTask(_task.value!!.id)
            loadTask()
            hideDeleteDialog()
        }
    }

    fun updateTask(newTask: Task){
        viewModelScope.launch {
            repository.updateTask(newTask)
            loadTask()
            hideUpdateDialog()
        }
    }

    fun showAddDialog(){
        _showAddDialog.value = true
    }
    fun showDeleteDialog(){
        _showDeleteDialog.value = true
    }
    fun showUpdateDialog(){
        _showUpdateDialog.value = true
    }

    fun hideAddDialog(){
        _showAddDialog.value = false
    }
    fun hideDeleteDialog(){
        _showDeleteDialog.value = false
    }
    fun hideUpdateDialog(){
        _showUpdateDialog.value = false
    }

}