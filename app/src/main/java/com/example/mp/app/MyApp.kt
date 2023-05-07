package com.example.mp.app

import android.app.Application
import com.example.mp.data.datasources.TasksDataBase
import com.example.mp.domain.TasksRepositoryImpl
import com.example.mp.pages.main.body.all_tasks.AllTasksViewModel
import com.example.mp.pages.main.body.new_task.NewTaskViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module


class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        val db = TasksDataBase.getDatabase(this@MyApp)
        startKoin {
            androidContext(this@MyApp)
            modules(
                module {
                    single {
                        TasksRepositoryImpl(db.todoDao())
                    }
                    viewModel {
                        NewTaskViewModel(get())
                    }
                    viewModel {
                        AllTasksViewModel(get())
                    }
                },
            )
        }
    }

}