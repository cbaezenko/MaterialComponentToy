package com.example.baeza.materialcomponentstoy.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.baeza.materialcomponentstoy.R
import com.example.baeza.materialcomponentstoy.network.ProductEntry

class ProductCardRecyclerViewAdapter(private val productList: List<ProductEntry>) : RecyclerView.Adapter<ProductCardRecyclerViewAdapter.ProductCardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ProductCardViewHolder {
    val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.product_card, parent, false)
        return ProductCardViewHolder(layoutView)
    }

    override fun getItemCount(): Int { return productList.size }

    override fun onBindViewHolder(holder: ProductCardViewHolder, position: Int) {
    }

    class ProductCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}