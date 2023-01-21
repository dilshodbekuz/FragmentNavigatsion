package com.example.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fragmentnavigatsion.R
import com.example.fragmentnavigatsion.databinding.ItemUsersBinding
import com.example.test.model.ImageModel


class UsersAdapter(val item: List<ImageModel>) : RecyclerView.Adapter<UsersAdapter.ItemHolder>() {
    class ItemHolder(val binding: ItemUsersBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(ItemUsersBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val items = item[position]
        
        holder.binding.tvUsers.text = items.user
        Glide.with(holder.itemView.context).load(items.userImageURL).placeholder(R.drawable.loading).into(holder.binding.ivUsers)
    }

    override fun getItemCount(): Int {
        return item.size
    }
}