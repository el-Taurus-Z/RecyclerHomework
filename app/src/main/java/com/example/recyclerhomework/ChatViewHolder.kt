package com.example.recyclerhomework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class ChatViewHolder(itemView: View, private val OnCardItemClickListener: OnCardItemClick) :
    RecyclerView.ViewHolder(itemView) {

    companion object {
        fun newInstance(parent: ViewGroup, OnCardItemClick: OnCardItemClick) = ChatViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false),
            OnCardItemClick
        )
    }

    private val nameOfCard by lazy { itemView.findViewById<TextView>(R.id.name_of_card) }
    private val rootView by lazy { itemView.findViewById<ConstraintLayout>(R.id.root) }

    fun bindItem(item: CardList) {
        with(item) {
            nameOfCard.text = NameOfCard
        }
        rootView.setOnClickListener {
            OnCardItemClickListener.OnItemClick(item)
        }

    }

}