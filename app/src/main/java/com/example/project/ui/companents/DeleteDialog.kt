package com.example.project.ui.companents

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun DeleteDialog(
    onDismiss:() -> Unit,
    onDelete:() -> Unit
){
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Вы точно хотите удалить?")},
        text = {"Вы уверены, что хотети удалить?"},
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Отмена")
            }
        },
        confirmButton = {
            TextButton(onClick = onDelete) {
                Text("Удалить")
            }
        },
    )
}