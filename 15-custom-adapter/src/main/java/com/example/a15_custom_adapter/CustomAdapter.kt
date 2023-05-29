package com.example.a15_custom_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.a15_custom_adapter.databinding.FruitListItemBinding

class CustomAdapter(context: Context, val fruitList: ArrayList<FruitModel>) :
    ArrayAdapter<FruitModel>(context, R.layout.fruit_list_item, fruitList) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var binding: FruitListItemBinding = if (convertView==null){
            FruitListItemBinding.inflate(LayoutInflater.from(context),parent,false)
        }else{
            FruitListItemBinding.bind(convertView)
        }
        binding.textName.text =fruitList[position].name
        binding.imageFruit.setImageResource(fruitList[position].image)
        return binding.root
    }

}

