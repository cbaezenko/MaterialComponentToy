package com.example.baeza.materialcomponentstoy.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.*
import com.example.baeza.materialcomponentstoy.R
import com.example.baeza.materialcomponentstoy.adapter.ProductCardRecyclerViewAdapter
import com.example.baeza.materialcomponentstoy.helper.ProductGridItemDecoration
import com.example.baeza.materialcomponentstoy.network.ProductEntry
import kotlinx.android.synthetic.main.product_grid_fragment.view.*

class ProductGridFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
            layoutInflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = layoutInflater.inflate(R.layout.product_grid_fragment, container, false)

        //Set up the toolbar
        (activity as AppCompatActivity).setSupportActionBar(view.app_bar)

        //Set up the RecyclerView
        view.recycler_view.setHasFixedSize(true)
        view.recycler_view.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        val adapter = ProductCardRecyclerViewAdapter(
                ProductEntry.initProductEntryList(resources))
        view.recycler_view.adapter = adapter
        val largePadding = resources.getDimensionPixelSize(R.dimen.shr_product_grid_spacing)
        val smallPadding = resources.getDimensionPixelSize(R.dimen.shr_product_grid_spacing_small)
        view.recycler_view.addItemDecoration(ProductGridItemDecoration(largePadding, smallPadding))

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, menuInflater: MenuInflater?){
        menuInflater!!.inflate(R.menu.toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, menuInflater)
    }
}