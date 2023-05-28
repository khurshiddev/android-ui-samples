package com.example.a13_info_user

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.example.a13_info_user.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("db", MODE_PRIVATE)
        binding.nameTv.text = "Name:  ${sharedPreferences.getString("name", "")}"
        binding.surnameTv.text = "Surename: ${sharedPreferences.getString("surname", "")}"
        binding.ageTv.text = "Age: ${sharedPreferences.getString("age","")}"

        binding.imageView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_in_anim))
        binding.nameTv.startAnimation(AnimationUtils.loadAnimation(this,R.anim.enter_right))
        binding.surnameTv.startAnimation(AnimationUtils.loadAnimation(this,R.anim.enter_left))
        binding.ageTv.startAnimation(AnimationUtils.loadAnimation(this,R.anim.enter_right))

        binding.clearBtn.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            finish()
        }

    }
}