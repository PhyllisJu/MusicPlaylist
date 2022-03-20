package com.example.spotifyplaylist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SongAdapter(private val songs: List<Song>) : RecyclerView.Adapter<SongAdapter.ViewHolder>() {

    class ViewHolder internal constructor(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val songName : TextView = itemView.findViewById(R.id.songName)
        val artist : TextView = itemView.findViewById(R.id.artist)
        val album : TextView = itemView.findViewById(R.id.album)
        val cover : ImageView = itemView.findViewById<ImageView>(R.id.cover)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.song_cell, parent, false) as View
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val song = songs[position]
        holder.songName.text = song.name
        holder.artist.text = song.artist
        holder.album.text = song.album
        holder.cover.setImageResource(song.cover)
        val context = holder.itemView.context
        holder.itemView.setOnClickListener {
            val songIntent = Intent(context, SongDetailActivity::class.java).apply {
                putExtra("position", position)
                putExtra("songName", song.name)
                putExtra("artist", song.artist)
                putExtra("album", song.album)
                putExtra("cover", song.cover)
            }
            context.startActivity(songIntent)
        }
    }

    override fun getItemCount(): Int {
        return songs.size
    }

}