package com.example.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fragmentnavigatsion.R
import com.example.fragmentnavigatsion.databinding.ItemImageBinding
import com.example.test.model.ImageModel

class ImageAdapter(val item: List<ImageModel>) : RecyclerView.Adapter<ImageAdapter.ItemHolders>() {
    class ItemHolders(val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolders {
        return ItemHolders(ItemImageBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ItemHolders, position: Int) {
        val items = item[position]

        holder.binding.tvImages.text = items.tags
        Glide.with(holder.itemView.context).load(items.largeImageURL).placeholder(R.drawable.loading).into(holder.binding.ivImage)
    }

    override fun getItemCount(): Int {
        return item.size
    }

}