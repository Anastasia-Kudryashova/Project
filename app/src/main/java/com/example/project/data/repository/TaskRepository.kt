package com.example.project.data.repository

import com.example.project.data.models.Task

class TaskRepository {
    private var tasks = mutableListOf<Task>()
    private var currentId = 1

    init {
        tasks.addAll(
            listOf(
                Task(
                    id = currentId++,
                    title = "Заголовок 1",
                    text = "Очень много текста".repeat(20),
                    expended = false
                ),
                Task(
                    id = currentId++,
                    title = "Заголовок 2",
                    text = "Очень много текста".repeat(20),
                    expended = true
                ),

            )
        )
    }

    fun getAllTasks() : List<Task> = tasks.toList()

    fun addTask(task: Task){
        tasks.add(task.copy(id = currentId++))
    }

    fun deleteTask(id: Int){
        tasks.removeAll { it.id == id}
    }

    fun updateTask(updateTask: Task){
        val index = tasks.indexOfFirst { it.id == updateTask.id }
        if (index != -1)
            tasks[index] = updateTask
    }
}