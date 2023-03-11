package com.khurshiddev.loginpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.khurshiddev.loginpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.NextButton.setOnClickListener {
            val intent =Intent(this,UIelements::class.java)
            startActivity(intent)
        }

        val userImage = findViewById<ImageView>(R.id.userImage)

        Glide
            .with(this)
            .load("https://images.unsplash.com/photo-1607252650355-f7fd0460ccdb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8YW5kcm9pZHxlbnwwfHwwfHw%3D&w=1000&q=80")
            .centerCrop()
            .into(userImage)


        val nameEt = findViewById<EditText>(R.id.name)
        val mailEt = findViewById<EditText>(R.id.mail)
        val passwordEt = findViewById<EditText>(R.id.passwor)
        val button = findViewById<Button>(R.id.button)
        val nameTv = findViewById<TextView>(R.id.nameTv)
        val mailTv = findViewById<TextView>(R.id.mailTv)
        val passwordTv = findViewById<TextView>(R.id.passworTv)

        button.setOnClickListener {
            nameTv.text = "Name: ${nameEt.text}"
            mailTv.text = "Your mail: ${mailEt.text}"
            passwordTv.text = "Your password: ${passwordEt.text}"

        }
    }
}