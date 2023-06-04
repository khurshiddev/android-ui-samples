package com.example.a23_view_pager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a23_view_pager2.databinding.SampleFragmentLayoutBinding

class SampleFragment() : Fragment() {

    private var _binding: SampleFragmentLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SampleFragmentLayoutBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageRes = arguments?.let {
            it.getInt("key")
        } ?: R.drawable.apple
        binding.imageView.setImageResource(imageRes)

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

