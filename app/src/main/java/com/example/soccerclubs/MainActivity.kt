package com.example.soccerclubs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.soccerclubs.data.SoccerTile

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val soccerTileList = getSoccerTileList()
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
                    headerImageUrl = "https://f-edits.tumblr.com/image/151089497233"
                ))
            add(
                SoccerTile(
                    id = "westham",
                    title = "Weatham",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.westham_header,
                    headerImageUrl = "https://f-edits.tumblr.com/image/151053901701"
                ))
            add(
                SoccerTile(
                    id = "paris",
                    title = "Paris",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.paris_header,
                    headerImageUrl = "https://f-edits.tumblr.com/image/151043279087"
                ))
            add(
                SoccerTile(
                    id = "arsenal",
                    title = "Arsenal",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.arsenal_header,
                    headerImageUrl = "https://f-edits.tumblr.com/image/150401426840"
                ))
            add(
                SoccerTile(
                    id = "borussia",
                    title = "Borussia",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.borussia_header,
                    headerImageUrl = "https://f-edits.tumblr.com/image/150356303395"
                ))
            add(
                SoccerTile(
                    id = "juventus",
                    title = "Juventus",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.juventus_header,
                    headerImageUrl = "https://f-edits.tumblr.com/image/150299524153"
                ))
        }
    }
}