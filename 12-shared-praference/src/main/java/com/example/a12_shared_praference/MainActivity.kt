package com.example.a12_shared_praference

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a12_shared_praference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences :SharedPreferences
    private var counter = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getPreferences(MODE_PRIVATE) //

        counter = sharedPreferences.getInt("count",0)
        binding.countTv.text = counter.toString()
        binding.incrementBtn.setOnClickListener {
            counter++
            binding.countTv.text = counter.toString()
        }
    }

    override fun onStop() {
        sharedPreferences.edit().putInt("counter",counter).apply()
        super.onStop()
    }
}