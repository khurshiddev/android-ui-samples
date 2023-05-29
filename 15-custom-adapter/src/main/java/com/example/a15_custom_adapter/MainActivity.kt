package com.example.a15_custom_adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a15_custom_adapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val fruits = arrayListOf<FruitModel>(
        FruitModel("Apple",R.drawable.apple),
        FruitModel("Apricot",R.drawable.apricot),
        FruitModel("Banana",R.drawable.banana),
        FruitModel("Grapes",R.drawable.grapes),
        FruitModel("Wateremelon",R.drawable.watermelon),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val adapter = CustomAdapter(this,fruits)
        binding.listView.adapter = adapter

    }
}