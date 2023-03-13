package com.example.buttonpress.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Database access object to access the ButtonPress database
 */
@Dao
interface ButtonPressDao {

    // Get the buttons from the latest buttonPressedAt
    @Query("SELECT * from buttonPress ORDER BY buttonPressedAt DESC")
    suspend fun getButtonPress(): List<ButtonPress>

    // Specify the conflict strategy as IGNORE, when the user tries to add an
    // existing ButtonPress into the database Room ignores the conflict.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: ButtonPress)
}
