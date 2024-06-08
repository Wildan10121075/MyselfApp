package com.wildan.myselfapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
// Wildan Permana - 10121075
// PemAndro3 - 08/06/2024
// Tugas Besar UTS
class FriendsAdapter(private val friendsList: List<Friend>) :
    RecyclerView.Adapter<FriendsAdapter.FriendViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_friend, parent, false)
        return FriendViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        val currentFriend = friendsList[position]
        holder.friendName.text = currentFriend.name
        holder.friendImage.setImageResource(currentFriend.imageResId)
    }

    override fun getItemCount() = friendsList.size

    class FriendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val friendName: TextView = itemView.findViewById(R.id.textViewFriendName)
        val friendImage: ImageView = itemView.findViewById(R.id.imageViewFriend)
    }
}
