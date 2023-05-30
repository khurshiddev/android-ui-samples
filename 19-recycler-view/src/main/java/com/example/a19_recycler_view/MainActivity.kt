package com.example.a19_recycler_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a19_recycler_view.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Collections

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titleList = mutableListOf<String>()
        val customAdapter = MyCustomAdapter(titleList)

        binding.recyclerView.adapter = customAdapter
        val myLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.recyclerView.apply {
            adapter = customAdapter
            layoutManager = myLayoutManager
            addItemDecoration(DividerItemDecoration(this@MainActivity,myLayoutManager.orientation))
        }
        val itemTouchHelper =ItemTouchHelper(object :MyItemTouchHelper(){
            override fun onItemSwipeToDelete(position: Int) {
                val removedTitle = titleList.removeAt(position)
                customAdapter.notifyItemRemoved(position)

                Snackbar.make(this@MainActivity,binding.recyclerView,"$removedTitle is going to be removed", Snackbar.LENGTH_LONG)
                    .setAction("Undo"){
                        titleList.add(position,removedTitle)
                        customAdapter.notifyItemInserted(position)
                    }.show()
            }

            override fun onItemMoved(from: Int, to: Int) {
            Collections.swap(titleList,from,to)
                customAdapter.notifyItemMoved(from,to)
            }

        })

        itemTouchHelper.attachToRecyclerView(binding.recyclerView)

        binding.addBtn.setOnClickListener {
            val title = binding.titleEt.text.toString()
            val newList = mutableListOf<String>()
            newList.addAll(titleList)
            if (title.isNotBlank()){
                newList.add(title.trim())
                customAdapter.submitList(newList)
                binding.titleEt.text.clear()
            }
        }

        customAdapter.setListener(object :RecyclerViewListener{
            override fun onItemClick(position: Int) {

            }

            override fun onDeleteBtnClick(position: Int) {
                titleList.removeAt(position)
                customAdapter.notifyItemRemoved(titleList.size)
                binding.titleEt.text.clear()
            }
        })
    }
}