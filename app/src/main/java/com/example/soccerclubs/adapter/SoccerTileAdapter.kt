package com.example.soccerclubs.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.soccerclubs.R
import com.example.soccerclubs.data.SoccerTile

class SoccerTileAdapter(
    private val data: ArrayList<SoccerTile>
): RecyclerView.Adapter<SoccerTileAdapter.SoccerTileViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoccerTileViewHolder {
        return SoccerTileViewHolder(parent)
    }

    override fun onBindViewHolder(holder: SoccerTileViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class SoccerTileViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_soccer_tile, parent, false)
    ) {

        private val headerImageView: ImageView = itemView.findViewById(R.id.teamHeaderImageView)
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        private val button: Button = itemView.findViewById(R.id.button)

        fun onBind(SoccerTile: SoccerTile) {
            headerImageView.setImageResource(SoccerTile.headerImageResId)
            titleTextView.text = SoccerTile.title
            descriptionTextView.text = SoccerTile.description
            button.setOnClickListener {
                Toast.makeText(it.context, "$adapterPosition", Toast.LENGTH_SHORT).show()
            }
        }
    }
}