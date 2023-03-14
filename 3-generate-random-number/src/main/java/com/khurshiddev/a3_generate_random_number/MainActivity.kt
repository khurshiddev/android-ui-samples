package com.khurshiddev.a3_generate_random_number

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.khurshiddev.a3_generate_random_number.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.generateBtn.setOnClickListener {
            val from = binding.Rslider.values[0]
            val to = binding.Rslider.values[1]

            if (binding.checkbox2.isChecked) {
                val randomNumber = Random.nextInt(from.toInt(), to.toInt())
                binding.resultTv.text = "Generate Number : $randomNumber"

            } else {

                val randomNumber = Random.nextDouble(from.toDouble(), to.toDouble())
                binding.resultTv.text = String.format("Generate Number : %.3f", randomNumber)
            }
        }

    }
}