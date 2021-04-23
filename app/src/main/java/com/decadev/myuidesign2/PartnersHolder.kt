package com.decadev.myuidesign2

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PartnersHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var partnersCompanyView = itemView.findViewById<TextView>(R.id.partnerscompany)
        var discountPriceView = itemView.findViewById<TextView>(R.id.discountprice)
        var productSalesView = itemView.findViewById<TextView>(R.id.productsales)
        var bagView = itemView.findViewById<ImageView>(R.id.alibag)
}