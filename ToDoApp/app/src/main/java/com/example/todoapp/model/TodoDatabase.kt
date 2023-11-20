package com.example.todoapp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapp.util.Util


@Database(entities = [Todo::class], version = 2)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object {
        @Volatile
        private var instance: TodoDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context): TodoDatabase {
            return instance ?: synchronized(LOCK) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }
        }

        private fun buildDatabase(context: Context): TodoDatabase {
            val util = Util() // Create an instance of Util
            return Room.databaseBuilder(
                context.applicationContext,
                TodoDatabase::class.java,
                "newtododb"
            )
                .addMigrations(util.MIGRATION_1_2) // Include the migration here
                .build()
        }
    }
}
