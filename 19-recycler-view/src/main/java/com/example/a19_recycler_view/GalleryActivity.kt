package com.example.a19_recycler_view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.a19_recycler_view.databinding.ActivityMainBinding

class GalleryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = listOf(
            R.drawable.apple,
            R.drawable.banana,
            R.drawable.apricot,
            R.drawable.cheery,
            R.drawable.blueberries,
            R.drawable.grapes,
            R.drawable.melon,
            R.drawable.orange,
            R.drawable.painapple,
            R.drawable.peach,
            R.drawable.strawberry,
            R.drawable.watermelon,
            R.drawable.apple,
            R.drawable.banana,
            R.drawable.apricot,
            R.drawable.cheery,
            R.drawable.blueberries,
            R.drawable.grapes,
            R.drawable.melon,
            R.drawable.orange,
            R.drawable.painapple,
            R.drawable.peach,
            R.drawable.strawberry,
            R.drawable.watermelon,
        )

        val galleryAdapter = MyGalleryAdapter(list)

        val myManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        binding.recyclerView.apply {
            adapter = galleryAdapter
            layoutManager = myManager
        }
        galleryAdapter.setListener(object : RecyclerViewListener {
            override fun onItemClick(position: Int) {
                Intent(this@GalleryActivity, ImageViewActivity::class.java).apply {
                    putExtra("image", list[position])
                    startActivity(this)
                }
            }

            override fun onDeleteBtnClick(position: Int) {

            }

        })
    }
}