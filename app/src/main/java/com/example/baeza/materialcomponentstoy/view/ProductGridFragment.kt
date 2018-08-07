package com.example.baeza.materialcomponentstoy.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.baeza.materialcomponentstoy.R

class ProductGridFragment : Fragment() {

    override fun onCreateView(
            layoutInflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = layoutInflater.inflate(R.layout.product_grid_fragment, container, false)
        return view
    }
}