package com.example.baeza.materialcomponentstoy.helper

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.android.volley.toolbox.NetworkImageView
import com.example.baeza.materialcomponentstoy.R
import kotlinx.android.synthetic.main.product_card.view.*


class ProductCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var productImage: ImageView = itemView.findViewById(R.id.product_image)
    var productTitle: TextView = itemView.findViewById(R.id.product_title)
    var productPrice: TextView = itemView.findViewById(R.id.product_price)
}