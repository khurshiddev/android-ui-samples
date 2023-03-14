package com.khurshiddev.a2_ui_elements

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.khurshiddev.a2_ui_elements.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.checkbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                Toast.makeText(this, "Checkbox checked", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Checkbox unchecked", Toast.LENGTH_SHORT).show()

        }
        binding.switcher.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                Toast.makeText(this, "Switcher on", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"Swicher off",Toast.LENGTH_SHORT).show()
        }
        binding.toggleBtn.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked)
                Toast.makeText(this,"Toggle Button checked",Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"Toggle Button unchecked",Toast.LENGTH_SHORT).show()
        }
        binding.slider.addOnChangeListener { _, value, _ -> 
            Toast.makeText(this,"Slider value changed $value", Toast.LENGTH_SHORT).show()
        }
        binding.rangeSlider.addOnChangeListener { s, value, fromUser ->
            Toast.makeText(this,"Slider value changed from ${s.values[0]} to ${s.values[1]}",Toast.LENGTH_SHORT).show()
        }
    }
}