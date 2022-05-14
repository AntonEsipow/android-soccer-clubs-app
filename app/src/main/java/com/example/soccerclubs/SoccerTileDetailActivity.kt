package com.example.soccerclubs

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.soccerclubs.data.SoccerTile

class SoccerTileDetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soccer_tile_detail)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Club Overview"
        }

        val soccerTile = intent.getSerializableExtra("soccerTile") as? SoccerTile ?: SoccerTile(
            id = "Oops",
            description = "Something goes wrong.",
            descriptionLong = "Please try again later",
            headerImageResId = R.drawable.error_header
        )

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
            else -> onOptionsItemSelected(item)
        }
    }
}