package com.example.baeza.materialcomponentstoy.view

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.*
import android.view.animation.AccelerateDecelerateInterpolator
import com.example.baeza.materialcomponentstoy.R
import com.example.baeza.materialcomponentstoy.adapter.ProductCardRecyclerViewAdapter
import com.example.baeza.materialcomponentstoy.helper.NavigationIconClickListener
import com.example.baeza.materialcomponentstoy.helper.ProductGridItemDecoration
import com.example.baeza.materialcomponentstoy.network.ProductEntry
import com.example.baeza.materialcomponentstoy.staggeredgridlayout.StaggeredProductCardRecyclerViewAdapter
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
        //add shape motion
//        view.app_bar.setNavigationOnClickListener(NavigationIconClickListener(activity!!, view.product_grid))
        view.app_bar.setNavigationOnClickListener(NavigationIconClickListener(
                activity!!,
                view.product_grid,
                AccelerateDecelerateInterpolator(),
                ContextCompat.getDrawable(context!!, R.drawable.shr_branded_menu), //Menu open Icon
                ContextCompat.getDrawable(context!!, R.drawable.shr_close_menu)))  //Menu close Icon


        // Set up the RecyclerView
        view.recycler_view.setHasFixedSize(true)
        val gridLayoutManager = GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position % 3 == 2) 2 else 1
            }
        }
        view.recycler_view.layoutManager = gridLayoutManager
        val adapter = StaggeredProductCardRecyclerViewAdapter(
                ProductEntry.initProductEntryList(resources))
        view.recycler_view.adapter = adapter
        val largePadding = resources.getDimensionPixelSize(R.dimen.shr_staggered_product_grid_spacing_large)
        val smallPadding = resources.getDimensionPixelSize(R.dimen.shr_staggered_product_grid_spacing_small)
        view.recycler_view.addItemDecoration(ProductGridItemDecoration(largePadding, smallPadding))

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            view.product_grid.background = context?.getDrawable(R.drawable.shr_product_grid_background_shape)
        }

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, menuInflater: MenuInflater?){
        menuInflater!!.inflate(R.menu.toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, menuInflater)
    }
}