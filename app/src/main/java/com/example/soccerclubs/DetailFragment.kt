package com.example.soccerclubs

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ImageView
import android.widget.TextView
import com.example.soccerclubs.data.SoccerTile
import com.squareup.picasso.Picasso

class DetailFragment : BaseMainActivityFragment(R.layout.fragment_detail) {

    private val soccerTile: SoccerTile by lazy {
        mainActivity.soccerTileList.find {
            it.id == requireArguments().getString("soccerTileId")
        } ?: SoccerTile()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        mainActivity.supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }

        setActionBarTitle("Club Overview")

        val headerImageView: ImageView = view.findViewById(R.id.teamHeaderImageView)
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = view.findViewById(R.id.descriptionTextView)
        val descriptionLongTextView: TextView = view.findViewById(R.id.descriptionLongTextView)

//        headerImageView.setImageResource(soccerTile.headerImageResId)
        Picasso.get().isLoggingEnabled = true
        Picasso.get()
            .load(soccerTile.headerImageUrl)
            .placeholder(R.drawable.footbal)
            .error(R.drawable.error_header)
            .into(headerImageView)
        titleTextView.text = soccerTile.title
        descriptionTextView.text = soccerTile.description
        descriptionLongTextView.text = soccerTile.descriptionLong
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                (activity as MainActivity).supportFragmentManager
                    .popBackStack()
                true
            }
            R.id.menuItemLink -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(soccerTile.teamUrl))
                startActivity(intent)
                return true
            }
            R.id.menuItemFavorite -> {
                val isCurrentFavorite = soccerTile.isFavorite
                if(isCurrentFavorite) {
                    item.setIcon(R.drawable.ic_favorite_outline_24dp)
                } else {
                    item.setIcon(R.drawable.ic_favorite_24dp)
                }
                soccerTile.isFavorite = !isCurrentFavorite
                true
            }
            else -> onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_soccer_tile_detail, menu)

        if(soccerTile.isFavorite)
            menu.findItem(R.id.menuItemFavorite)?.setIcon(R.drawable.ic_favorite_24dp)
    }
}