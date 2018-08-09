package com.example.baeza.materialcomponentstoy.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.baeza.materialcomponentstoy.R
import com.example.baeza.materialcomponentstoy.helper.ProductCardViewHolder
import com.example.baeza.materialcomponentstoy.network.ProductEntry
import com.squareup.picasso.Picasso

class ProductCardRecyclerViewAdapter(private val productList: List<ProductEntry>) : RecyclerView.Adapter<ProductCardViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ProductCardViewHolder {
    val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.product_card, parent, false)
        return ProductCardViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: ProductCardViewHolder, position: Int) {
        if(position < productList.size){
            val product = productList[position]
            holder.productTitle.text = product.title
            holder.productPrice.text = product.price

            Picasso.get().load(product.url).placeholder(R.drawable.ic_launcher_background).error(R.drawable.kot).into(holder.productImage)
        }
    }

    override fun getItemCount(): Int { return productList.size }
}