package com.decadev.myuidesign2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView

class PartnersAdapter: RecyclerView.Adapter<PartnersHolder>() {

    var partnersName = arrayOf("AliExpress", "Aviasales", "Bookgram")
    var discounts = arrayOf("from 4%", "from 4.4%", "from 4%")
    var itemsSold = arrayOf("Clothes and shoes", "tickets and travels", "Booking and scheduling")
    var bags = arrayOf(R.drawable.ic_shopping_bag_1, R.drawable.ic_aviabag, R.drawable.ic_aviabag)

//This is the method/function that creates and defines the layout to be displayed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartnersHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.product_layout, parent, false)
        return PartnersHolder(view)
    }

    //This gets the number of items in our list/data
    override fun getItemCount(): Int {
        return partnersName.size
    }

    //onBindViewHolder Binds the view to the data to be displayed
    override fun onBindViewHolder(holder: PartnersHolder, position: Int) {
        holder.partnersCompanyView.text = partnersName[position]
        holder.discountPriceView.text = discounts[position]
        holder.productSalesView.text = itemsSold[position]
        holder.bagView.setImageResource(bags[position])

    }
}