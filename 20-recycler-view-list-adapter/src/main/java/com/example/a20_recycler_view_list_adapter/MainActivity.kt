package com.example.a20_recycler_view_list_adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a20_recycler_view_list_adapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       val lisAdapter = MyListAdapter()
        binding.recyclerView.apply {
            adapter = lisAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        val list = mutableListOf<String>()
        for (i in 1..100){
            list.add("Title $i")
        }
        lisAdapter.submitList(list)
    }
}