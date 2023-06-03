package com.example.a22_create_fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.a22_create_fragment.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    val TAG = "Fragment First"

    lateinit var textView: TextView
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!   //not null
    private var sharedString: String? = null
    private lateinit var intirface :FirstFragmentInterface

    override fun onAttach(context: Context) {
        super.onAttach(context)
        intirface = activity as MainActivity
        Log.d(TAG, "onAttach: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedString = arguments?.let {  //get shared String
            it.getString("key")
        }
        Log.d(TAG, "onCreate: ")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return _binding?.root
        Log.d(TAG, "onCreateView: ")

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ") // mana shu blockda biz amaliyotlarimizni bajara olarkanmiz
        binding.button.setOnClickListener {
            val text = binding.textEt.text.toString()
            intirface.onClickButton(text)
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach: ")
    }
}