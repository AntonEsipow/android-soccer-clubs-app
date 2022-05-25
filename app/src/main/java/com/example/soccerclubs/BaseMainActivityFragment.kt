package com.example.soccerclubs

import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso

abstract class BaseMainActivityFragment(layoutId: Int) : Fragment(layoutId) {

    val mainActivity : MainActivity by lazy { activity as MainActivity }

    fun setActionBarTitle(title: String) {
        mainActivity.supportActionBar?.title = title
    }
}