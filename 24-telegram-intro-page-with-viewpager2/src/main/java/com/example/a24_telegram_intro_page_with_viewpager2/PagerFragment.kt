package com.example.a24_telegram_intro_page_with_viewpager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a24_telegram_intro_page_with_viewpager2.databinding.ItemPagerBinding

private var _binding: ItemPagerBinding? = null
private val binding get() = _binding!!

class PagerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ItemPagerBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.apply {
            binding.imageView.setImageResource(getInt("image",R.drawable.logo))
            binding.titleTv.text = getString("title")
            binding.descriptionTv.text = getString("des")
        }
    }
}