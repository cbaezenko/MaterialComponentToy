package com.example.baeza.materialcomponentstoy.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.*
import com.example.baeza.materialcomponentstoy.R
import kotlinx.android.synthetic.main.product_grid_fragment.view.*

class ProductGridFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
            layoutInflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = layoutInflater.inflate(R.layout.product_grid_fragment, container, false)
        (activity as AppCompatActivity).setSupportActionBar(view.app_bar)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, menuInflater: MenuInflater?){
        menuInflater!!.inflate(R.menu.toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, menuInflater)
    }
}