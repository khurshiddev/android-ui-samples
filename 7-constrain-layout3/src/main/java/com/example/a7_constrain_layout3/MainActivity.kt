package com.example.a7_constrain_layout3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7_constrain_layout3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.plusBtn.setOnClickListener {
            val firsNumber = binding.firsNumEt.text.toString().toInt()
            val secondNumber = binding.secondNumEt.text.toString().toInt()
            binding.resultTv.text = "RESULT: ${firsNumber + secondNumber}"
        }

        binding.minusBtn.setOnClickListener {
            val firstNumber = binding.firsNumEt.text.toString().toInt()
            val secondNumber = binding.secondNumEt.text.toString().toInt()
            binding.resultTv.text = "RESULT: ${firstNumber - secondNumber}"
        }

        binding.multiplyBtn.setOnClickListener {
            val firstNumber = binding.firsNumEt.text.toString().toInt()
            val secondNumber = binding.secondNumEt.text.toString().toInt()
            binding.resultTv.text = "RESULT: ${firstNumber * secondNumber}"
        }

        binding.devideBtn.setOnClickListener {
            val firstNumber = binding.firsNumEt.text.toString().toInt()
            val secondNumber = binding.secondNumEt.text.toString().toInt()
            binding.resultTv.text = "RESULT: ${firstNumber/secondNumber}"
        }
    }
}