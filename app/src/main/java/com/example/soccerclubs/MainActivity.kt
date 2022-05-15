package com.example.soccerclubs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.soccerclubs.adapter.SoccerTileAdapter
import com.example.soccerclubs.data.SoccerTile

class MainActivity : AppCompatActivity(), SoccerTileInterface {

    companion object {
        lateinit var soccerTileList: ArrayList<SoccerTile>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        soccerTileList = getSoccerTileList()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val soccerTileAdapter = SoccerTileAdapter(soccerTileList, this)

        recyclerView.adapter = soccerTileAdapter
    }

    override fun onLearnMoreButtonClicked(position: Int) {
        val soccerTile = soccerTileList[position]
        val intent = Intent(this, SoccerTileDetailActivity::class.java).apply {
            putExtra("soccerTileId", soccerTile.id)
        }
        startActivity(intent)
    }

    private fun getSoccerTileList(): ArrayList<SoccerTile> {
        return ArrayList<SoccerTile>().apply {
            add(
                SoccerTile(
                    id = "everton",
                    title = "Everton",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.everton_header,
                    headerImageUrl = "https://f-edits.tumblr.com/image/151089497233",
                    teamUrl = "https://www.evertonfc.com/"
                ))
            add(
                SoccerTile(
                    id = "westham",
                    title = "Weatham",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.westham_header,
                    headerImageUrl = "https://f-edits.tumblr.com/image/151053901701",
                    teamUrl = "https://www.whufc.com/"
                ))
            add(
                SoccerTile(
                    id = "paris",
                    title = "Paris",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.paris_header,
                    headerImageUrl = "https://f-edits.tumblr.com/image/151043279087",
                    teamUrl = "https://parisfc.fr/"
                ))
            add(
                SoccerTile(
                    id = "arsenal",
                    title = "Arsenal",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.arsenal_header,
                    headerImageUrl = "https://f-edits.tumblr.com/image/150401426840",
                    teamUrl = "https://www.arsenal.com/"
                ))
            add(
                SoccerTile(
                    id = "borussia",
                    title = "Borussia",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.borussia_header,
                    headerImageUrl = "https://f-edits.tumblr.com/image/150356303395",
                    teamUrl = "https://www.bvb.de/eng"
                ))
            add(
                SoccerTile(
                    id = "juventus",
                    title = "Juventus",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.juventus_header,
                    headerImageUrl = "https://f-edits.tumblr.com/image/150299524153",
                    teamUrl = "https://www.juventus.com/en/"
                ))
        }
    }
}