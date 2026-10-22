package com.example.project.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project.data.repository.TaskRepository
import com.example.project.ui.taskList.TaskListScreen
import com.example.project.ui.taskList.TaskListViewModel

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun AppNavigation() {
    val repository = remember { TaskRepository() }
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        "TaskList"
    ) {
        composable("TaskList") {
            TaskListScreen(
                TaskListViewModel(repository)
            )
        }
        composable("TaskAdd") {

        }
        composable("TaskEdit") {

        }
    }

}