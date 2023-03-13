package com.example.buttonpress.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Database class with a singleton INSTANCE object.
 */
@Database(entities = [ButtonPress::class], version = 1, exportSchema = false)
abstract class ButtonPressRoomDatabase : RoomDatabase() {

    abstract fun buttonPressDao(): ButtonPressDao

    companion object {
        @Volatile
        private var INSTANCE: ButtonPressRoomDatabase? = null

        fun getDatabase(context: Context): ButtonPressRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ButtonPressRoomDatabase::class.java,
                    "button_press_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}