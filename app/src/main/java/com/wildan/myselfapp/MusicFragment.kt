package com.wildan.myselfapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
// Wildan Permana - 10121075
// PemAndro3 - 08/06/2024
// Tugas Besar UTS
class MusicFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MusicAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_music, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        // Buat daftar musik favorit
        val musicList = listOf(
            Music("Daily Mix 2", "Akane, Shyane Orok, Eve and more", "https://open.spotify.com/playlist/37i9dQZF1E35h0BmfVUD85?si=6f5252767d6f4ff8", R.drawable.album1),
            Music("Daily Mix 3", "JKT48, Mahalini, Mahen and more", "https://open.spotify.com/playlist/37i9dQZF1E35zTlMbKR5OE?si=ffefec08eeec4f3a", R.drawable.album2),
            Music("Daily Mix 4", "Tulus, Yura Yunita, Budi Doremi and more", "https://open.spotify.com/playlist/37i9dQZF1E36b11iMITlo2?si=079e5d5735f64556", R.drawable.album3),
            Music("Daily Mix 5", "Judika, ST12, For Revenge and more", "https://open.spotify.com/playlist/37i9dQZF1E36R8cB92aRHW?si=a51826ff81354096", R.drawable.album4),
            Music("Daily Mix 5", "7!!, Tulus, Cakra Khan and more", "https://open.spotify.com/playlist/37i9dQZF1EQqedj0y9Uwvu?si=c10213c6cde34c3b", R.drawable.album5),
            Music("Daily Mix 1", "Fourtwnty, Soegi Bornean, Reality Club and more", "https://open.spotify.com/playlist/37i9dQZF1E38dL2W68NYNw?si=e6706d8ff71f4ee6", R.drawable.album6),
            Music("Fourtwenty Album", "This is Fourtwnty. The essential tracks, all in one playlist", "https://open.spotify.com/playlist/37i9dQZF1DZ06evO2otVhd?si=bbdfde2b2b044229", R.drawable.fourtwenty),
            Music("Tulus Album", "This is Tulus. The essential tracks, all in one playlist", "https://open.spotify.com/playlist/37i9dQZF1DZ06evO1jm2Q1?si=4d9a373cf6674a27", R.drawable.tulus),
            Music("Hivi Album", "This is Hivi. The essential tracks, all in one playlist", "https://open.spotify.com/playlist/37i9dQZF1DZ06evO2CUGQc?si=fc5cd4fd54bc49f8", R.drawable.hivi),
            Music("JKT48 Album", "This is JKT48. The essential tracks, all in one playlist", "https://open.spotify.com/playlist/37i9dQZF1DZ06evO1kR98I?si=f0de20da54be4596", R.drawable.jkt),
            Music("Juicy Luicy Album", "This is Juicy Luicy. The essential tracks, all in one playlist", "https://open.spotify.com/playlist/37i9dQZF1DZ06evO21mH97?si=6cc0fa4490194064", R.drawable.juicy_luicy),
            // Tambahkan musik lainnya di sini
        )

        adapter = MusicAdapter(musicList) { music ->
            // Mengatur listener untuk setiap item musik
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(music.link))
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        return view
    }
}

data class Music(val title: String, val artist: String, val link: String, val imageResource: Int)

class MusicAdapter(private val musicList: List<Music>, private val onItemClick: (Music) -> Unit) :
    RecyclerView.Adapter<MusicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.music_item, parent, false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val music = musicList[position]
        holder.bind(music)
        holder.itemView.setOnClickListener { onItemClick(music) }
    }

    override fun getItemCount(): Int {
        return musicList.size
    }
}

class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(music: Music) {
        itemView.findViewById<TextView>(R.id.txt_judul).text = music.title
        itemView.findViewById<TextView>(R.id.txt_artis).text = music.artist
        itemView.findViewById<ImageView>(R.id.albumImageView).setImageResource(music.imageResource)
    }
}
