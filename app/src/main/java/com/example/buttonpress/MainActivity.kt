package com.example.buttonpress

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.buttonpress.data.ButtonPress
import com.example.buttonpress.data.ButtonPressRoomDatabase
import com.example.buttonpress.databinding.ActivityMainBinding
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val database by lazy { ButtonPressRoomDatabase.getDatabase(this).buttonPressDao() }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
        binding.buttonLogs.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when (p0.id) {
            binding.button1.id -> insertToLogs("Button 1 pressed")
            binding.button2.id -> insertToLogs("Button 2 pressed")
            binding.button3.id -> insertToLogs("Button 3 pressed")
            binding.button4.id -> insertToLogs("Button 4 pressed")
            binding.buttonLogs.id -> {
                // Open Logs
                val intent = Intent(applicationContext, LogsActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun insertToLogs(log: String) {
        lifecycleScope.launch {
            database.insert( ButtonPress( buttonName = log, buttonPressedAt = System.currentTimeMillis() ) )
        }
    }
}