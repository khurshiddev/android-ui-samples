package com.example.a14_list_adapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a14_list_adapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val fruits = arrayListOf<FruitModel>(
        FruitModel("Apple",R.drawable.apple),
        FruitModel("Apricot",R.drawable.apricot),
        FruitModel("Banana",R.drawable.banana),
        FruitModel("Grapes",R.drawable.grapes),
        FruitModel("Watermelon",R.drawable.watermelon),
    )
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = CustomAdapter(this,fruits)
        binding.listView.adapter =adapter

        binding.listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this,"${fruits[position]} Choose", Toast.LENGTH_SHORT).show()
            Intent(this,FruitImageActivity::class.java).apply {
                this.putExtra("position",position)
                startActivity(this)
            }
        }


    }
}