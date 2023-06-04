package com.example.a24_view_pager_use_advantage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class CustomViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity)
{
    override fun getItemCount(): Int {
        return 10
    }

    override fun createFragment(position: Int): Fragment {
        TODO("Not yet implemented")
    }
}