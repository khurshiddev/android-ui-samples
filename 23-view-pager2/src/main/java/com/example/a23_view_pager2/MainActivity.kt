package com.example.a23_view_pager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a23_view_pager2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val customVIewPagerAdapter = CustomVIewPagerAdapter(this)
        binding.myViewPager.adapter = customVIewPagerAdapter

        TabLayoutMediator(binding.tableLayout,binding.myViewPager){tab, position->
            tab.text = "Title $position"
        }.attach()
    }
}