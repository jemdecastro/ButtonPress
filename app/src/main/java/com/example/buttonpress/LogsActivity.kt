package com.example.buttonpress

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.buttonpress.data.ButtonPress
import com.example.buttonpress.data.ButtonPressRoomDatabase
import com.example.buttonpress.databinding.ActivityLogsBinding
import kotlinx.coroutines.launch

class LogsActivity : AppCompatActivity() {

    private val database by lazy { ButtonPressRoomDatabase.getDatabase(this).buttonPressDao() }

    private lateinit var binding: ActivityLogsBinding
    private lateinit var adapter: LogsRecyclerViewAdapter
    private lateinit var itemsList: List<ButtonPress>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLogsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = GridLayoutManager(applicationContext, 1)

        lifecycleScope.launch {
            itemsList = database.getButtonPress()
            adapter = LogsRecyclerViewAdapter(itemsList)
            binding.recyclerView.adapter = adapter
        }
    }
}