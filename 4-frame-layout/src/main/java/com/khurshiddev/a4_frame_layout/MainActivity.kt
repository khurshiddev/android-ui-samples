package com.khurshiddev.a4_frame_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.khurshiddev.a4_frame_layout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}