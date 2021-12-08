package com.itis.a1semitis


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var adapter: SongAdapter? = null
    lateinit var songList: List<Song>

    @SuppressLint("UseCompatLoadingForDrawables")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        songList = SongRepository.getSong()
        adapter = SongAdapter(
            songList
        ) {
            val intent = Intent(this, TrackPage::class.java)
            intent.putExtra("position", SongRepository.getPosition(it.author, it.title))
            val intentService = Intent(baseContext, PlayService::class.java)
            stopService(intentService)
            startActivity(intent)
        }
        rv_song.adapter = adapter
        rv_song.layoutManager = LinearLayoutManager(this)
    }
}