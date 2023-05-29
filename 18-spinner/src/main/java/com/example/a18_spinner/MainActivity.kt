package com.example.a18_spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.a18_spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = listOf("Canada","America","Australia","Swiss-land","Japan","South-Korea")
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val name = binding.spinner.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity,name,Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }
}