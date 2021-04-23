package com.decadev.myuidesign2

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.animation.AnimationUtils

class CardViewPagerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//views to be binded in the adapter to the required data.
    var cutomerNameOnCard = itemView.findViewById<TextView>(R.id.nameOnCard_textView)
    var customerAcctBalance = itemView.findViewById<TextView>(R.id.acctbalance_textView)
    var cardColor = itemView.findViewById<CardView>(R.id.visacardView)
}
