package com.example.a24_telegram_intro_page_with_viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a24_telegram_intro_page_with_viewpager2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = listOf<ModelData>(
            ModelData(R.drawable.logo,"Telegram",""),
            ModelData(R.drawable.fast,"Fast",""),
            ModelData(R.drawable.gift,"GIft",""),
            ModelData(R.drawable.cloud,"Cloud",""),
            ModelData(R.drawable.powerful,"Powerful",""),
        )
        val customPagerAdapter = CustomPagerAdapter(this,list)

        binding.viewPager.adapter = customPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager){tab, position ->

        }.attach()
    }
}