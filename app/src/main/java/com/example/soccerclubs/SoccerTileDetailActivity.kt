package com.example.soccerclubs

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.soccerclubs.data.SoccerTile

class SoccerTileDetailActivity: AppCompatActivity() {

    private lateinit var soccerTile: SoccerTile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soccer_tile_detail)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Club Overview"
        }

        val selectedSoccerTileId = intent.getStringExtra("soccerTileId")

//        soccerTile = MainActivity.soccerTileList.find {
//            it.id == selectedSoccerTileId
//        } ?: SoccerTile(
//            id = "Oops",
//            description = "Something goes wrong.",
//            descriptionLong = "Please try again later",
//            headerImageResId = R.drawable.error_header
//        )

        val headerImageView: ImageView = findViewById(R.id.teamHeaderImageView)
        val titleTextView: TextView = findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = findViewById(R.id.descriptionTextView)
        val descriptionLongTextView: TextView = findViewById(R.id.descriptionLongTextView)

        headerImageView.setImageResource(soccerTile.headerImageResId)
        titleTextView.text = soccerTile.title
        descriptionTextView.text = soccerTile.description
        descriptionLongTextView.text = soccerTile.descriptionLong
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                finish()
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_soccer_tile_detail, menu)

        if(soccerTile.isFavorite)
            menu?.findItem(R.id.menuItemFavorite)?.setIcon(R.drawable.ic_favorite_24dp)
        return true
    }
}