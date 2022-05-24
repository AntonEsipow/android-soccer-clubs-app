package com.example.soccerclubs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.soccerclubs.adapter.SoccerTileAdapter
import com.example.soccerclubs.data.SoccerTile

class ListFragment : BaseMainActivityFragment(R.layout.fragment_list) {

    private lateinit var soccerTileAdapter: SoccerTileAdapter
    private val soccerTileList: ArrayList<SoccerTile>
        get() = mainActivity.soccerTileList

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivity.supportActionBar?.apply{
            setDisplayHomeAsUpEnabled(false)
        }

        setActionBarTitle("Soccer Clubs Home")

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        soccerTileAdapter = SoccerTileAdapter(soccerTileList, mainActivity)
        recyclerView.adapter = soccerTileAdapter
    }

    override fun onResume() {
        super.onResume()
        soccerTileAdapter.notifyDataSetChanged()
    }

    fun onFavoriteClicked(position: Int) {
        soccerTileAdapter.notifyItemChanged(position)
    }

}