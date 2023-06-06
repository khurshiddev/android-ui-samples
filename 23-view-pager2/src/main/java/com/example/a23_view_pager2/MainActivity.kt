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

        val customViewPagerAdapter = CustomViewPagerAdapter(this)
        binding.myViewPager.adapter = customViewPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.myViewPager) { tab, position ->
            tab.text = " Title is Title"
        }.attach()

    }
}