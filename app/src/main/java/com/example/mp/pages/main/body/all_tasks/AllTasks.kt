package com.example.mp.pages.main.body.all_tasks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import org.koin.androidx.compose.get


@Composable
fun AllTasks(
    viewModel: AllTasksViewModel = AllTasksViewModel(get())
) {

    val list = viewModel.tasks.observeAsState()


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (list.value == null) {
            Box {}
        } else {
            LazyColumn {
                items(list.value!!.size) { index ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = list.value!![index].name,
                            fontSize = 32.sp
                        )
                        Checkbox(
                            checked = list.value!![index].status,
                            onCheckedChange = {
                                viewModel.updateTask(index, it)
                            }
                        )
                    }
                }
            }
        }
    }
}