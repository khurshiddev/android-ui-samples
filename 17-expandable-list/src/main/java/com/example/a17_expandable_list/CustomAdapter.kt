package com.example.a17_expandable_list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.a17_expandable_list.databinding.ChildLayoutBinding
import com.example.a17_expandable_list.databinding.GroupLayoutBinding

class CustomAdapter(
    context: Context,
    val groupList: List<String>,
    val childMap: Map<String, List<String>>
) : BaseExpandableListAdapter() {

    val inflater = LayoutInflater.from(context)
    override fun getGroupCount(): Int {
        return groupList.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        val groupName = groupList[groupPosition]
        return childMap[groupName]!!.size
    }

    override fun getGroup(groupPosition: Int): Any {
        return groupList[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        val groupName = groupList[groupPosition]
        return childMap[groupName]!![childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val binding: GroupLayoutBinding = if (convertView == null) {
            GroupLayoutBinding.inflate(inflater, parent, false)
        } else {
            GroupLayoutBinding.bind(convertView)
        }
        binding.groupTv.text = groupList[groupPosition]
        return binding.root
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val groupName = groupList[groupPosition]
        val childMap = childMap[groupName]?.get(childPosition)

        val binding: ChildLayoutBinding = if (convertView == null) {
            ChildLayoutBinding.inflate(inflater, parent, false)
        } else {
            ChildLayoutBinding.bind(convertView)
        }
        binding.childTv.text = childMap
        return binding.root
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}