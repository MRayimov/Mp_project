package com.example.mp.pages.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mp.pages.main.body.all_tasks.AllTasks
import com.example.mp.pages.main.body.new_task.NewTask
import com.example.mp.ui.theme.MPTheme

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = viewModel()
) {

    val pageIndex = viewModel.pageIndex.collectAsStateWithLifecycle()


    val configuration = LocalConfiguration.current
    val screenWidth = (configuration.screenWidthDp - 32).dp

    Column(
        modifier = Modifier.fillMaxSize(),

        ) {

        Box(
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Button(
                    onClick = { viewModel.onPageIndexChange(0) },
                    modifier = Modifier
                        .width((screenWidth / 2))
                        .height(45.dp)
                ) {

                    Icon(
                        imageVector = Icons.Default.List,
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                }
                Button(
                    onClick = { viewModel.onPageIndexChange(1) },
                    modifier = Modifier
                        .width((screenWidth / 2))
                        .height(45.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                }


            }

        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
        ) {
            if (pageIndex.value == 0) {
                AllTasks()
            } else {
                NewTask()
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MPTheme {
        MainScreen()
    }
}

