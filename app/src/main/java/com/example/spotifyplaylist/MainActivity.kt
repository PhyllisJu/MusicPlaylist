package com.example.spotifyplaylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val names = listOf("Don't Look Back in Anger", "Mary", "What Kind Of Woman Is This?",
    "Burning Pile", "Exit Music", "Love Of My Life", "Dealbreaker", "Seventeen", "Cruisin",
    "Last Night on Earth")
    private val artists = listOf("Oasis", "Big Thief", "Buddy Guy", "Mother Mother", "Radiohead",
    "Queen", "Rachael Yamagata", "Karen Ann", "Sioen", "Green Day")
    private val albums = listOf("Don't Look Back in Anger", "Capacity", "Bring 'Em In/Skin Deep",
        "O My Heart", "OK Computer", "Special Edition GOLD", "Chesapeake", "Not Going Anywhere",
    "See You Naked", "21st Century Breakdown")
    private val images = listOf(R.drawable.anger, R.drawable.mary, R.drawable.woman, R.drawable.buddy, R.drawable.exit,
        R.drawable.lovelife, R.drawable.dealbreaker, R.drawable.seventeen, R.drawable.cruisin, R.drawable.earth)

    private lateinit var list: RecyclerView
    private var songList = mutableListOf<Song>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list = findViewById(R.id.list)

        for(i in names.indices) {
            songList.add(Song(names[i], artists[i], albums[i], images[i]))
        }

        val adapter = SongAdapter(songList)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val songName = intent.extras?.getString("songName")
        val artist = intent.extras?.getString("artist")
        val album = intent.extras?.getString("album")
        val cover = intent.extras?.getInt("cover")
        val position = intent.extras?.getInt("position")

        if (songName != null && artist != null && album != null && cover != null && position != null) {
            songList[position] = Song(songName, artist, album, cover)
            adapter.notifyItemChanged(position)
        }


    }
}