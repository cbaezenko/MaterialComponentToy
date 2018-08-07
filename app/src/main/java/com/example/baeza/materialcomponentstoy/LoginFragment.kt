package com.example.baeza.materialcomponentstoy

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.login_fragment.*
import kotlinx.android.synthetic.main.login_fragment.view.*

class LoginFragment : Fragment() {

    override fun onCreateView(
            layoutInflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutInflater.inflate(R.layout.login_fragment, container, false)
        setWelcomePhoto(view)

        view.button_login_next.setOnClickListener {
            if (!isPasswordValid(edit_text_login_userpass.text!!)) {
                textInput_login_pass.error = getString(R.string.login_password_error)
            } else {
                textInput_login_pass.error = null
            }
        }

        view.edit_text_login_userpass.setOnKeyListener { _, _, _ ->
            if (isPasswordValid(edit_text_login_userpass.text!!)) {
                edit_text_login_userpass.error = null
            }
            false
        }

        return view
    }

    private fun isPasswordValid(text: Editable?): Boolean { return text != null && text.length >= 8 }

    private fun setWelcomePhoto(view: View) {
        Picasso.get().load(R.drawable.kot).transform(CircleTransformation()).into(view.imageView_login_welcomephoto)
    }
}