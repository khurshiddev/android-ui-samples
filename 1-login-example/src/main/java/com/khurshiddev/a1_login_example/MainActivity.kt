package com.khurshiddev.a1_login_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.khurshiddev.a1_login_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide
            .with(this)
            .load("https://images.unsplash.com/photo-1607252650355-f7fd0460ccdb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8YW5kcm9pZHxlbnwwfHwwfHw%3D&w=1000&q=80")
            .centerCrop()
            .placeholder(R.drawable.img)
            .error(R.drawable.ic_launcher_background)
            .into(binding.userImaGe)


        binding.button2.setOnClickListener {
            binding.NameTV.text = "Your Name: ${binding.nameET.text}"
            binding.mailTV.text = "Your Mail: ${binding.mailET.text}"
            binding.passwordTV.text = "Password: ${binding.passwordET.text}"
        }

    }
}