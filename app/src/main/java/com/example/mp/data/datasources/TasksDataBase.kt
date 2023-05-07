package com.example.mp.data.datasources

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mp.data.models.TaskDto


@Database(entities = [TaskDto::class], version = 1)
abstract class TasksDataBase : RoomDatabase() {
    abstract fun todoDao(): TasksDao

    companion object {
        @Volatile
        private var  INSTANCE : TasksDataBase? = null

        fun getDatabase(context: Context): TasksDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TasksDataBase::class.java,
                    "TasksDataBase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}