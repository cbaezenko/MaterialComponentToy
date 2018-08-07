package com.example.baeza.materialcomponentstoy.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.baeza.materialcomponentstoy.R
import com.example.baeza.materialcomponentstoy.helper.NavigationHost

class MainActivity : AppCompatActivity(), NavigationHost {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, LoginFragment()).commit()
        }
    }

    /**
     * Navigate tothe given fragment.
     *
     * @param fragment       Fragment to navigate to.
     * @param addToBackstack Whether or not the current fragment should be added to the backstack.
     */


    override fun navigateTo(fragment: Fragment, addToBackstack: Boolean) {
        val transaction = supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
        if(addToBackstack){transaction.addToBackStack(null)}
        transaction.commit()
    }
}
