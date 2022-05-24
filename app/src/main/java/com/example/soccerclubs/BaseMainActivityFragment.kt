package com.example.soccerclubs

import androidx.fragment.app.Fragment

abstract class BaseMainActivityFragment(layoutId: Int) : Fragment(layoutId) {

    val mainActivity : MainActivity by lazy { activity as MainActivity }

    fun setActionBarTitle(title: String) {
        mainActivity.supportActionBar?.title = title
    }
}