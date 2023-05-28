package com.example.a11_animation_alpha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.example.a11_animation_alpha.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.alphaBtn.setOnClickListener {
            val alphaAnim = AnimationUtils.loadAnimation(this, R.anim.alpha_anim)
            binding.imageView.startAnimation(alphaAnim)
        }
        binding.rotateBtn.setOnClickListener {
            val rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim)
            binding.imageView.startAnimation(rotateAnim)
        }

        binding.translateBtn.setOnClickListener {
            val translateAnim = AnimationUtils.loadAnimation(this, R.anim.translate_anim)
            binding.imageView.startAnimation(translateAnim)
        }
        binding.scaleBtn.setOnClickListener {
            val scaleAnim = AnimationUtils.loadAnimation(this, R.anim.scale_anim)
            binding.imageView.startAnimation(scaleAnim)
        }
        binding.combinationBtn.setOnClickListener {
            val combinationAnim = AnimationUtils.loadAnimation(this,R.anim.combination_anim)
            binding.imageView.startAnimation(combinationAnim)
        }
    }
}