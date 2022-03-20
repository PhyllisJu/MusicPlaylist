package com.example.spotifyplaylist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class SongDetailActivity : AppCompatActivity() {

    private lateinit var coverInput : ImageView
    private lateinit var songNameInput : EditText
    private lateinit var artistInput : EditText
    private lateinit var albumInput : EditText
    private lateinit var saveBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_detail)

        coverInput = findViewById(R.id.cover_input)
        songNameInput = findViewById(R.id.songName_input)
        artistInput = findViewById(R.id.artist_input)
        albumInput = findViewById(R.id.album_input)
        saveBtn = findViewById(R.id.save)

        var songName = intent.extras?.getString("songName")
        var artist = intent.extras?.getString("artist")
        var album = intent.extras?.getString("album")
        var cover = intent.extras?.getInt("cover")
        var position = intent.extras?.getInt("position")

        songNameInput.setText(songName)
        artistInput.setText(artist)
        albumInput.setText(album)

        if (cover != null) {
            coverInput.setImageResource(cover)
        }

        saveBtn.setOnClickListener {

            songName = songNameInput.text.toString()
            artist = artistInput.text.toString()
            album = albumInput.text.toString()

            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("songName", songName)
                putExtra("artist", artist)
                putExtra("album", album)
                putExtra("cover", cover)
                putExtra("position", position)
            }
            startActivity(intent)
        }
    }
}