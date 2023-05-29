package com.example.a14_list_adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.a14_list_adapter.databinding.ActivityFruitImageBinding


class FruitImageActivity : AppCompatActivity() {
private val fruits = arrayListOf("Apple","Apricot","Banana","Grapes","Watermelon")
    private lateinit var binding: ActivityFruitImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFruitImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.getIntExtra("position",0)
        supportActionBar?.title = fruits[position]
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        when(position){
            0 -> binding.fruitImage.setImageResource(R.drawable.apple)
            1 -> binding.fruitImage.setImageResource(R.drawable.apricot)
            2 -> binding.fruitImage.setImageResource(R.drawable.banana)
            3 -> binding.fruitImage.setImageResource(R.drawable.grapes)
            4 -> binding.fruitImage.setImageResource(R.drawable.watermelon)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}