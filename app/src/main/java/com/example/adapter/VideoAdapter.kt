package com.example.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentnavigatsion.R
import com.example.fragmentnavigatsion.databinding.ItemVideoBinding
import com.example.test.model.Model
import com.squareup.picasso.Picasso

class VideoAdapter(val item: List<Model>) : RecyclerView.Adapter<VideoAdapter.ViewHolder>() {
   inner class ViewHolder(val binding: ItemVideoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemVideoBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = item[position]


        holder.binding.tvVideo.text = items.tags
        Picasso.get().load(items.pageURL).placeholder(R.drawable.image).into(holder.binding.ivVideo)

    }

    override fun getItemCount(): Int {
        return item.size

    }
}