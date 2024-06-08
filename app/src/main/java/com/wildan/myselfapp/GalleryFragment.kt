package com.wildan.myselfapp

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
// Wildan Permana - 10121075
// PemAndro3 - 08/06/2024
// Tugas Besar UTS
class GalleryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)

        val galleryList = listOf(
            Gallery(R.drawable.camp_artapela, getString(R.string.txt_artapela)),
            Gallery(R.drawable.lari_lap_cimaung, getString(R.string.txt_lari)),
            Gallery(R.drawable.nimo_highland, getString(R.string.txt_nimo)),
            Gallery(R.drawable.motor_dilan, getString(R.string.txt_dilan)),
            Gallery(R.drawable.img_basket, getString(R.string.txt_basket)),
            Gallery(R.drawable.img_kereta, getString(R.string.txt_kereta)),
            Gallery(R.drawable.img_braga, getString(R.string.txt_braga)),
            Gallery(R.drawable.img_cafe, getString(R.string.txt_cafe)),
        )

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_grid)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = context?.let { GalleryAdapter(it, galleryList) }

        return view
    }
}