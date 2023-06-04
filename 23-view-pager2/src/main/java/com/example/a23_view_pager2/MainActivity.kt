package com.example.a23_view_pager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2.PageTransformer
import com.example.a23_view_pager2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import java.lang.StrictMath.abs
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = listOf(
            R.drawable.apple,
            R.drawable.apricot,
            R.drawable.banana,
            R.drawable.grapes,
            R.drawable.watermelon,
        )

        val title = listOf(
            "Apple",
            "Apricot",
            "Banana",
            "Grapes",
            "Watermelon",
        )

        val data = listOf<CustomDataModel>(
            CustomDataModel(R.drawable.baseline_home_24,R.drawable.apple,"Apple"),
            CustomDataModel(R.drawable.baseline_format_list_bulleted_24,R.drawable.apricot,"Apricot"),
            CustomDataModel(R.drawable.baseline_filter_list_24,R.drawable.banana,"Banana"),
            CustomDataModel(R.drawable.baseline_info_24,R.drawable.watermelon,"Watermelon"),
                )

        val customVIewPagerAdapter = CustomVIewPagerAdapter(this,data.map { it.image })
        binding.myViewPager.adapter = customVIewPagerAdapter

        TabLayoutMediator(binding.tableLayout, binding.myViewPager){tab,position ->
            tab.text = title[position]
            tab.setIcon(data[position].icon)
            val badge = tab.orCreateBadge
            badge.number = Random.nextInt(500)
        }.attach()

        binding.myViewPager.apply {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
        }
        binding.myViewPager.apply {
            setPageTransformer(CompositePageTransformer().apply {
                addTransformer(MarginPageTransformer(40))
                addTransformer(object :PageTransformer{
                    override fun transformPage(page: View, position: Float) {
                        page.apply {
                            alpha = 0.85F + 0.15F*(1-(abs(position)))
                        }
                    }
                })
            })
        }
    }
}