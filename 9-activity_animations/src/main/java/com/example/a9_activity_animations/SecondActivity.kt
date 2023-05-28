package com.example.a9_activity_animations

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a9_activity_animations.databinding.ActivityMainBinding
import com.example.a9_activity_animations.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.doneBtn.setOnClickListener {
            val age =binding.doneEt.text.toString()
            val intent = Intent()
            intent.putExtra("age",age)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}