package com.example.a19_recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.a19_recycler_view.databinding.ItemGalleryLayoutBinding

class MyGalleryAdapter(val imageList: List<Int>) : Adapter<MyGalleryAdapter.MyGalleryViewHolder>() {

    private var recyclerViewListener: RecyclerViewListener? = null

    inner class MyGalleryViewHolder(val binding: ItemGalleryLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                recyclerViewListener?.onItemClick(adapterPosition)
            }
        }

        fun bind(imageId: Int) {
            binding.galleryImage.setImageResource(imageId)
        }
    }

    fun setListener(listener: RecyclerViewListener) {
        recyclerViewListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyGalleryViewHolder {
        return MyGalleryViewHolder(
            ItemGalleryLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: MyGalleryViewHolder, position: Int) {
        holder.bind(imageList[position])
    }


}