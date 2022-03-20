package com.example.recyclerhomework

import android.os.Bundle
import android.text.InputFilter
import android.text.Spanned
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottomsheet_fragment.*
import kotlinx.android.synthetic.main.item_chat.*

class MainActivity : AppCompatActivity() {
    private val chooseCard by lazy { findViewById<TextView>(R.id.chooseCard) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()
        val bottomSheetFragment=BottomSheetFragment(senderItem)
        chooseCard.setOnClickListener() {
            bottomSheetFragment.show(supportFragmentManager, "New Dialog")
        }
    }

    private val senderItem = object : SenderItem {
        override fun sendItem(item: CardList) {
            chooseCard.setText(item.NameOfCard)
        }
    }


}