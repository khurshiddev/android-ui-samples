package com.example.a13_info_user

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.a13_info_user.databinding.ActivityAddUserBinding

class AddUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddUserBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.imageView2.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in_anim))
        binding.saveBtn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.enter_bottom))
        binding.surNameEt.startAnimation(AnimationUtils.loadAnimation(this, R.anim.enter_left))
        binding.surNameEt.startAnimation(AnimationUtils.loadAnimation(this, R.anim.enter_right))
        binding.ageEt.startAnimation(AnimationUtils.loadAnimation(this, R.anim.enter_left))
        sharedPreferences = getSharedPreferences("db", MODE_PRIVATE)

        binding.saveBtn.setOnClickListener {
            val name = binding.surNameEt.text.toString()
            val surname = binding.surNameEt.text.toString()
            val age = binding.ageEt.text.toString()
            if (name.isNotBlank() && surname.isNotBlank() && age.isNotBlank()) {
                sharedPreferences.edit().putString("name", name).apply()
                sharedPreferences.edit().putString("surname", surname).apply()
                sharedPreferences.edit().putString("age", age).apply()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(this, "this information must be enter", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        if (sharedPreferences.getString("name", "") != "")
            Intent(this,MainActivity::class.java).apply {// bu tepadagi val intent
                // ni o'zin i yaratadi yangi ochmasdan
                startActivity(this)
                finish()
            }
        super.onStart()
    }
    }

