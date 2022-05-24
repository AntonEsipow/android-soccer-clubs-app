package com.example.soccerclubs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.soccerclubs.adapter.SoccerTileAdapter
import com.example.soccerclubs.data.SoccerTile

class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var soccerTileAdapter: SoccerTileAdapter
    private val soccerTileList: ArrayList<SoccerTile>
        get() = (activity as MainActivity).soccerTileList

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).supportActionBar?.apply{
            title = "Soccer Clubs Home"
            setDisplayHomeAsUpEnabled(false)
        }

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        soccerTileAdapter = SoccerTileAdapter(soccerTileList, activity as MainActivity)
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