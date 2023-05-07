@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mp.pages.main.body.new_task

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.getViewModel


@Composable
fun NewTask(
    viewModel: NewTaskViewModel = getViewModel()
) {
    val context = LocalContext.current

    val text = viewModel.text.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(modifier = Modifier.height(52.dp))

        TextField(
            value = text.value,
            onValueChange = { newText ->
                viewModel.onTextChange(newText)
            }
        )
        Box(modifier = Modifier.height(24.dp))
        Button(onClick = {
            viewModel.onSubmit()
            Toast.makeText(
                context,
                "Successfully saved!",
                Toast.LENGTH_LONG
            ).show()
        }) {
            Text("Save!")
        }

    }
}