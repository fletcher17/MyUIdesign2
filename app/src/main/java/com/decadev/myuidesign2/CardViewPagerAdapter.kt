package com.decadev.myuidesign2

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlin.coroutines.coroutineContext

class CardViewPagerAdapter: RecyclerView.Adapter<CardViewPagerHolder>() {

    var namesOnCard = arrayOf("Darot", "Olalekan", "Dapo", "Wilson", "Femi")
    var accountBalance = arrayOf("$ 23, 481,000.00", "$ 50, 481,000.00", "$ 30, 481,000.00", "$ 45, 481,000.00", "$ 49, 481,000.00")
    var cardColors = arrayOf(Color.BLACK, Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW)



//This is the method/function that creates and defines the layout to be displayed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewPagerHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_layout, parent, false)
        return CardViewPagerHolder(view)
    }

    //This gets the number of items in our list/data
    override fun getItemCount(): Int {
        return namesOnCard.size
    }

    //onBindViewHolder Binds the view to the data to be displayed
    override fun onBindViewHolder(holder: CardViewPagerHolder, position: Int) {
        holder.cutomerNameOnCard.text = namesOnCard[position]
        holder.customerAcctBalance.text = accountBalance[position]
        holder.cardColor.setCardBackgroundColor(cardColors[position])

    }
}