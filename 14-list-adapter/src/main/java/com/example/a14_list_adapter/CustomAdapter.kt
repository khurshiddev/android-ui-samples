package com.example.a14_list_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.a14_list_adapter.databinding.FruitListItemLayoutBinding

class CustomAdapter(context: Context, val fruitList: ArrayList<FruitModel>) :
    ArrayAdapter<FruitModel>(context, R.layout.fruit_list_item_layout, fruitList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var binding: FruitListItemLayoutBinding = if (convertView == null) {
            FruitListItemLayoutBinding.inflate(
                LayoutInflater.from(context), parent, false
            )
        } else {
            FruitListItemLayoutBinding.bind(convertView)
        }
        binding.nameTv.text = fruitList[position].name
        binding.fruitsImage.setImageResource(fruitList[position].image)
        return binding.root

    }
}