package com.example.a16_grid_view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a16_grid_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    private val imageList = arrayListOf(
        R.drawable.apple,
        R.drawable.apricot,
        R.drawable.banana,
        R.drawable.blueberries,
        R.drawable.cheery,
        R.drawable.grapes,
        R.drawable.melon,
        R.drawable.orange,
        R.drawable.painapple,
        R.drawable.strawberry,
        R.drawable.watermelon,
        R.drawable.peach,
        R.drawable.apple,
        R.drawable.apricot,
        R.drawable.banana,
        R.drawable.blueberries,
        R.drawable.cheery,
        R.drawable.grapes,
        R.drawable.melon,
        R.drawable.orange,
        R.drawable.painapple,
        R.drawable.strawberry,
        R.drawable.watermelon,
        R.drawable.peach,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = GalleryAdapter(this,imageList)
        binding.gridView.adapter =adapter
        binding.gridView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this,"$position choose", Toast.LENGTH_SHORT).show()
            Intent(this,FruitImageActivity::class.java).apply {
                this.putExtra("position",position).toString()
                startActivity(this)
            }
        }
    }
}