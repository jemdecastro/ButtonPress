package com.example.buttonpress.data

import android.text.format.DateUtils
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

/**
 * Entity data class represents a single row in the database.
 */
@Entity
data class ButtonPress(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name = "buttonName")
    val buttonName: String,

    @ColumnInfo(name = "buttonPressedAt")
    val buttonPressedAt: Long,
)

/**
 * Returns the formatted DateTime from the timestamp
 */
fun ButtonPress.getDateTime(): String {
    return try {
//        // Check if today, display getRelativeTimeSpanString(long ms), for example "42 minutes ago"
//        if(DateUtils.isToday(buttonPressedAt))
//            DateUtils.getRelativeTimeSpanString(buttonPressedAt).toString()
//        else {
//            // Else display a formatted datetime
//            val sdf = SimpleDateFormat("MMM dd yyyy, h:mm:ss a", Locale.ENGLISH)
//            sdf.format(Date(buttonPressedAt))
//        }

        val sdf = SimpleDateFormat("MMM dd yyyy, h:mm:ss a", Locale.ENGLISH)
        sdf.format(Date(buttonPressedAt))
    } catch (e: Exception) {
        ""
    }
}