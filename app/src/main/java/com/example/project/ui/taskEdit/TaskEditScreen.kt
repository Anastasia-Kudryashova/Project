package com.example.project.ui.taskEdit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.project.data.models.Task
import com.example.project.ui.taskAdd.TaskAddViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskEditScreen(
    navController: NavController,
    viewModel: TaskEditViewModel
) {
    val task by viewModel.task.collectAsState()

    var title by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }

    LaunchedEffect(task) {
        task?.let {
            text = it.text
            title = it.title
        }
    }
    Scaffold(topBar = {
        TopAppBar(
            { Text("Добавить новую задачу") }
        )
    }
    ) { paddingValues ->

        Column(modifier = Modifier.padding(paddingValues)) {
            Text("Добавить новую задачу?")

            OutlinedTextField(
                value = title,
                onValueChange = { title == it },
                label = { Text("Название задачи") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)

            )
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Текст") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true,
                maxLines = 3

            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                TextButton(onClick = { navController.popBackStack() }) {
                    Text("Отмена")
                }
                TextButton(onClick = {
                    if (title.isNotBlank() and text.isNotBlank())
                        viewModel.updateTask(
                            Task(
                                id = task!!.id,
                                text = text,
                                title = title,
                                expended = false
                            )
                        )
                    navController.popBackStack()
                }) {
                    Text("Изменить")
                }
            }
        }
    }
}