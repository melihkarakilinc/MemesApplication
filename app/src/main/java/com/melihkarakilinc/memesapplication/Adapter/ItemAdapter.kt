package com.melihkarakilinc.memesapplication.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.melihkarakilinc.memesapplication.Meme
import com.melihkarakilinc.memesapplication.Util.ItemClickListener
import com.melihkarakilinc.memesapplication.databinding.ItemLayoutBinding

class ItemAdapter() :
    PagingDataAdapter<Meme, ItemAdapter.MemeViewHolder>(MemeDiffCallback) {
    lateinit var clickListener:ItemClickListener
    override fun onBindViewHolder(holder: MemeViewHolder, position: Int) {
        val meme = getItem(position)
        if (meme != null) {
            holder.bind(meme)
            holder.binding.cardView.setOnClickListener {
                clickListener.OnItemSelect(meme)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(inflater)
        return MemeViewHolder(binding)
    }

    class MemeViewHolder(val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(meme: Meme) {
            binding.meme = meme
        }
    }

    object MemeDiffCallback : DiffUtil.ItemCallback<Meme>() {
        override fun areItemsTheSame(oldItem: Meme, newItem: Meme): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Meme, newItem: Meme): Boolean {
            return oldItem == newItem
        }
    }
}
