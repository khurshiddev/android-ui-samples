package com.example.a20_recycler_view_list_adapter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a20_recycler_view_list_adapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lisAdapter = MyListAdapter()
        binding.swipeRefresh.setOnRefreshListener {

            Handler().postDelayed({
                lisAdapter.submitList(getTitleList())
                binding.swipeRefresh.isRefreshing = false
            }, 3000)
        }

        binding.swipeRefresh.setColorSchemeColors(
            Color.RED,
            Color.BLUE,
            Color.GREEN
        )


        binding.recyclerView.apply {
            adapter = lisAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        lisAdapter.submitList(getTitleList())
    }

    private fun getTitleList(): List<String> {
        val list = mutableListOf<String>()
        for (i in 1..100) {
            list.add("Title $i")
        }
        return list
    }
}