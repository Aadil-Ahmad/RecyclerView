package com.example.recyclerviewbinding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewbinding.R
import com.example.recyclerviewbinding.databinding.ItemLayoutBinding
import com.example.recyclerviewbinding.model.MainDataModel

class MainAdapter(private val data : List<MainDataModel>): RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val inflate = LayoutInflater.from(parent.context)
       val binding : ItemLayoutBinding = DataBindingUtil.inflate(inflate, R.layout.item_layout, parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(private val binding: ItemLayoutBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(item: MainDataModel){
            binding.itemModel = item
            binding.executePendingBindings()
        }

    }
}