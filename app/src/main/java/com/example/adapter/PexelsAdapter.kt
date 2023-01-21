package com.example.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fragmentnavigatsion.databinding.ItemPexelsBinding
import com.example.model.ModelList
import com.example.model.Pexels

class PexelsAdapter(val item:List<ModelList>):RecyclerView.Adapter<PexelsAdapter.ItemHolder>() {
    class ItemHolder(val binding: ItemPexelsBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(ItemPexelsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val items = item[position]

        holder.binding.tvPexel.text = items.category
        Glide.with(holder.itemView.context).load(items.image).into(holder.binding.ivPexel)
    }

    override fun getItemCount(): Int {
        return item.size
    }
}