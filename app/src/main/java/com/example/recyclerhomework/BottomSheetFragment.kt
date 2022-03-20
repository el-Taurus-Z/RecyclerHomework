package com.example.recyclerhomework

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottomsheet_fragment.*
import kotlinx.android.synthetic.main.item_chat.*


class BottomSheetFragment(senderItem: SenderItem) : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottomsheet_fragment, container, false)
    }

    private val adapter by lazy { ChatAdapter(OnCardItemClick) }


    private val OnCardItemClick by lazy {
        object : OnCardItemClick {
            override fun OnItemClick(item: CardList) {
                senderItem.sendItem(item)
                dismiss()
            }

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler.adapter = adapter
        adapter.submitList(
            Storage.list
        )

    }


    object Storage {
        val list = listOf(
            CardList(
                "GTX 2080"
            ),
            CardList("RTX 3060")
        )
    }


}