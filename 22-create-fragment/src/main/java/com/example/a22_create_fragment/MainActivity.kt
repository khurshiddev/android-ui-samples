package com.example.a22_create_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a22_create_fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),FirstFragmentInterface {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //with apply{}
        val firstFragment = FirstFragment().apply {
            arguments = Bundle().apply {
                putString("key", "Assalom aleykum")
            }
        }

        //without apply{}

        /*val firstFragment = FirstFragment()
        val bundle = Bundle()
        bundle.putString("key","Hello")
        firstFragment.arguments = bundle*/

        val secondFragment = SecondFragment().apply {
            arguments = Bundle().apply {
                putString("key", "Valeykum Assalom")
            }
        }
        supportFragmentManager.apply {
            beginTransaction().replace(R.id.container, firstFragment).addToBackStack(null)
                .commit()
        }

        binding.showFirstFragment.setOnClickListener {
            supportFragmentManager.apply {
                beginTransaction().replace(R.id.container, firstFragment).addToBackStack(null)
                    .commit()
            }
        }
        binding.showSecondFragment.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, secondFragment) // without .apply{}
                .addToBackStack(null).commit()
        }
    }

    override fun onClickButton(text: String) {

        val secondFragment = SecondFragment().apply {
            arguments = Bundle().apply {
                putString("key",text)
            }
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, secondFragment) // without .apply{}
            .addToBackStack(null).commit()
    }
}