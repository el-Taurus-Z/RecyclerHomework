package com.example.recyclerhomework

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(private val OnCardItemClick: OnCardItemClick) :
    RecyclerView.Adapter<ChatViewHolder>() {
    private var items: List<CardList> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return ChatViewHolder.newInstance(parent, OnCardItemClick)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bindItem(items[position])

    }

    override fun getItemCount(): Int = items.size

    fun submitList(data: List<CardList>) {
        items = data
        notifyDataSetChanged()
    }


}