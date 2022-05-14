package com.example.soccerclubs.data

import java.io.Serializable

data class SoccerTile(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val descriptionLong: String = "",
    val buttonText: String = "",
    val headerImageResId: Int = 0,
    val headerImageUrl: String? = null,
    val teamUrl: String = "",
    var isFavorite: Boolean = false
): Serializable

// everton https://f-edits.tumblr.com/image/151089497233
// westham https://f-edits.tumblr.com/image/151053901701
// paris https://f-edits.tumblr.com/image/151043279087
// arsenal https://f-edits.tumblr.com/image/150401426840
// borussia https://f-edits.tumblr.com/image/150356303395
// juventus https://f-edits.tumblr.com/image/150299524153