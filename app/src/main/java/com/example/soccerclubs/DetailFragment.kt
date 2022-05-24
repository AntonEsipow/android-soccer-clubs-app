package com.example.soccerclubs

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.soccerclubs.data.SoccerTile

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val soccerTile: SoccerTile by lazy {
        (activity as MainActivity).soccerTileList.find {
            it.id == requireArguments().getString("soccerTileId")
        } ?: SoccerTile()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("DetailFragment", soccerTile.toString())
    }
}