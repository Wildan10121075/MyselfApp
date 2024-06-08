package com.wildan.myselfapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
// Wildan Permana - 10121075
// PemAndro3 - 08/06/2024
// Tugas Besar UTS
class DailyFragment : Fragment() {

    private lateinit var adapter: MyAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var newsArrayList: ArrayList<News>

    private lateinit var imageId: Array<Int>
    private lateinit var heading: Array<String>
    private lateinit var isi: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daily, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()

        // Inisialisasi RecyclerView untuk Friends List
        val friendsRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewFriends)
        friendsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val friends = listOf(
            Friend("Fai", R.drawable.ic_fai),
            Friend("Alvin", R.drawable.ic_alvin),
            Friend("Adrian", R.drawable.ic_adrian),
            Friend("Faliq", R.drawable.ic_faliq),
            Friend("Moris", R.drawable.ic_moris),
            Friend("Nasza", R.drawable.ic_nasza)
            // Tambahkan lebih banyak teman di sini
        )

        friendsRecyclerView.adapter = FriendsAdapter(friends)

        // Inisialisasi RecyclerView untuk Daily News
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycle_view) // Use the correct ID
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MyAdapter(newsArrayList)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize() {
        newsArrayList = arrayListOf<News>()

        imageId = arrayOf(
            R.drawable.dy_kuliah,
            R.drawable.dy_musik,
            R.drawable.dy_game,
            R.drawable.dy_basket,
            R.drawable.dy_lari,
            R.drawable.dy_berenang,
            R.drawable.dy_tugas
        )

        heading = arrayOf(
            getString(R.string.h_kuliah),
            getString(R.string.h_musik),
            getString(R.string.h_games),
            getString(R.string.h_basket),
            getString(R.string.h_lari),
            getString(R.string.h_berenang),
            getString(R.string.h_tugas),

            )

        isi = arrayOf(
            getString(R.string.sub_kuliah),
            getString(R.string.sub_musik),
            getString(R.string.sub_games),
            getString(R.string.sub_basket),
            getString(R.string.sub_lari),
            getString(R.string.sub_berenang),
            getString(R.string.sub_tugas),
        )

        for (i in imageId.indices) {
            val newsItem = News(imageId[i], heading[i], isi[i])
            newsArrayList.add(newsItem)
        }
    }
}
