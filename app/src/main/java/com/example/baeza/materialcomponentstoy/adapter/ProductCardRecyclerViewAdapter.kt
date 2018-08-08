package com.example.baeza.materialcomponentstoy.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.baeza.materialcomponentstoy.R
import com.example.baeza.materialcomponentstoy.helper.ProductCardViewHolder
import com.example.baeza.materialcomponentstoy.network.ProductEntry

class ProductCardRecyclerViewAdapter(private val productList: List<ProductEntry>) : RecyclerView.Adapter<ProductCardViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ProductCardViewHolder {
    val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.product_card, parent, false)
        return ProductCardViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: ProductCardViewHolder, position: Int) {
    }

    override fun getItemCount(): Int { return productList.size }

}