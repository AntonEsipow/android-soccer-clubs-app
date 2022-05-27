package com.example.soccerclubs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.example.soccerclubs.adapter.SoccerTileAdapter
import com.example.soccerclubs.data.SoccerTile

class MainActivity : AppCompatActivity(), SoccerTileInterface {

    lateinit var soccerTileList: ArrayList<SoccerTile>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        soccerTileList = getList()

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.fragmentContainerView, ListFragment())
        }
    }

    override fun onLearnMoreButtonClicked(position: Int) {
        val soccerTile = soccerTileList[position]

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            addToBackStack(null)
            val bundle = Bundle().apply {
                putString("soccerTileId", soccerTile.id)
            }
            replace(R.id.fragmentContainerView, DetailFragment().apply {
                arguments = bundle
            })
        }
    }

    override fun onFavoriteClicked(position: Int) {
        val soccerTile = soccerTileList[position]
        soccerTile.isFavorite = !soccerTile.isFavorite

        (supportFragmentManager.fragments[0] as? ListFragment)
            ?.onFavoriteClicked(position)

        SharedPrefUtil.setSoccerTileFavorite(soccerTile.id, soccerTile.isFavorite)
    }

    private fun getList(): ArrayList<SoccerTile> {
        return ArrayList<SoccerTile>().apply {
            add(
                SoccerTile(
                    id = "everton",
                    title = "Everton",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.everton_header,
                    headerImageUrl = "https://xn----ftbtfpb0b.xn--p1ai/wp-content/uploads/everton-big.png",
                    teamUrl = "https://www.evertonfc.com/",
                    isFavorite = SharedPrefUtil.getSoccerTileFavorite("everton")
                ))
            add(
                SoccerTile(
                    id = "west_ham",
                    title = "West Ham",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.westham_header,
                    headerImageUrl = "https://xn----ftbtfpb0b.xn--p1ai/wp-content/uploads/west-ham-united-big.png",
                    teamUrl = "https://www.whufc.com/",
                    isFavorite = SharedPrefUtil.getSoccerTileFavorite("west_ham")
                ))
            add(
                SoccerTile(
                    id = "leicester_city",
                    title = "Leicester City",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.paris_header,
                    headerImageUrl = "https://xn----ftbtfpb0b.xn--p1ai/wp-content/uploads/leicester-city-big.png",
                    teamUrl = "https://parisfc.fr/",
                    isFavorite = SharedPrefUtil.getSoccerTileFavorite("leicester_city")
                ))
            add(
                SoccerTile(
                    id = "arsenal",
                    title = "Arsenal",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.arsenal_header,
                    headerImageUrl = "https://xn----ftbtfpb0b.xn--p1ai/wp-content/uploads/arsenal-big.png",
                    teamUrl = "https://www.arsenal.com/",
                    isFavorite = SharedPrefUtil.getSoccerTileFavorite("arsenal")
                ))
            add(
                SoccerTile(
                    id = "borussia",
                    title = "Borussia",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.borussia_header,
                    headerImageUrl = "https://xn----ftbtfpb0b.xn--p1ai/wp-content/uploads/borussia-dortmund-big.png",
                    teamUrl = "https://www.bvb.de/eng",
                    isFavorite = SharedPrefUtil.getSoccerTileFavorite("borussia")
                ))
            add(
                SoccerTile(
                    id = "juventus",
                    title = "Juventus",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.juventus_header,
                    headerImageUrl = "https://xn----ftbtfpb0b.xn--p1ai/wp-content/uploads/juventus-big.png",
                    teamUrl = "https://www.juventus.com/en/",
                    isFavorite = SharedPrefUtil.getSoccerTileFavorite("juventus")
                ))
        }
    }
}