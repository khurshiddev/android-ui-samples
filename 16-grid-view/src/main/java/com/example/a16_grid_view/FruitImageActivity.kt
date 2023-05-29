package com.example.a16_grid_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.a16_grid_view.databinding.ActivityFruitImageBinding

class FruitImageActivity : AppCompatActivity() {
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
    private lateinit var binding: ActivityFruitImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFruitImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.getIntExtra("position",0)

        supportActionBar?.title = imageList[position].toString()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        when(position){
            0 -> binding.imageViewFruit.setImageResource(R.drawable.apple)
            1 -> binding.imageViewFruit.setImageResource(R.drawable.apricot)
            2 -> binding.imageViewFruit.setImageResource(R.drawable.banana)
            3 -> binding.imageViewFruit.setImageResource(R.drawable.blueberries)
            4 -> binding.imageViewFruit.setImageResource(R.drawable.cheery)
            5 -> binding.imageViewFruit.setImageResource(R.drawable.grapes)
            6 -> binding.imageViewFruit.setImageResource(R.drawable.melon)
            7 -> binding.imageViewFruit.setImageResource(R.drawable.orange)
            8 -> binding.imageViewFruit.setImageResource(R.drawable.painapple)
            9 -> binding.imageViewFruit.setImageResource(R.drawable.peach)
            10 -> binding.imageViewFruit.setImageResource(R.drawable.strawberry)
            11 -> binding.imageViewFruit.setImageResource(R.drawable.watermelon)
            12 -> binding.imageViewFruit.setImageResource(R.drawable.apple)
            13 -> binding.imageViewFruit.setImageResource(R.drawable.apricot)
            14 -> binding.imageViewFruit.setImageResource(R.drawable.banana)
            15 -> binding.imageViewFruit.setImageResource(R.drawable.blueberries)
            16 -> binding.imageViewFruit.setImageResource(R.drawable.cheery)
            17 -> binding.imageViewFruit.setImageResource(R.drawable.grapes)
            18 -> binding.imageViewFruit.setImageResource(R.drawable.melon)
            19 -> binding.imageViewFruit.setImageResource(R.drawable.orange)
            20 -> binding.imageViewFruit.setImageResource(R.drawable.painapple)
            21 -> binding.imageViewFruit.setImageResource(R.drawable.peach)
            22 -> binding.imageViewFruit.setImageResource(R.drawable.strawberry)
            23 -> binding.imageViewFruit.setImageResource(R.drawable.watermelon)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}