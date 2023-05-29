package com.example.a19_recycler_view

interface RecyclerViewListener {
    fun onItemClick(position:Int)
    fun onDeleteBtnClick(position: Int)
}