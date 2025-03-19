package com.test.qolami.view.adapter.pelajaran

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.test.qolami.R
import com.test.qolami.databinding.DataPelajaran1Binding
import com.test.qolami.view.pelajaran.data.DataAudioHijaiyaj
import com.test.qolami.view.pelajaran.data.DataMenuPelajaran1Huruf

class PelajaranHuruf1Adapter( var listHurufHijaiyah: ArrayList<DataAudioHijaiyaj>): RecyclerView.Adapter<PelajaranHuruf1Adapter.ViewHolder>() {
    class ViewHolder(var binding: DataPelajaran1Binding):RecyclerView.ViewHolder(binding.root) {
         var exoPlayer: ExoPlayer? = null
         var audioEnded = false
         var isPlaying = false
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = DataPelajaran1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHurufHijaiyah.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            Glide.with(holder.itemView).load(listHurufHijaiyah[position].gambar).into(holder.binding.imageView2)
        var grid = position / 5
        val color = when(grid % 6){
            0 -> R.color.choklat
            1 -> R.color.oren
            2 -> R.color.biru_tua
            3 -> R.color.warna_hijau_tua
            4 -> R.color.ungu
            else -> R.color.choklat_muda
        }
        val test = holder.itemView.context.resources.getColor(color, null)
        holder.binding.cv.setCardBackgroundColor(test)
        holder.exoPlayer = ExoPlayer.Builder(holder.itemView.context).build().also {
            // We still bind the player to the PlayerView but the view is gone
            holder.binding.exoPlayer!!.player = it
            // URL dari API atau sumber audio lainnya
            val mediaItem = MediaItem.fromUri("android.resource://${holder.itemView.context.packageName}/${listHurufHijaiyah[position].audio}")
            it.setMediaItem(mediaItem)
            it.prepare()
            holder.audioEnded = false
            it.addListener(object : Player.Listener {
                override fun onPlaybackStateChanged(state: Int) {
                    if (state == Player.STATE_ENDED) {
                        holder.isPlaying = false
                        holder.audioEnded = true
                    }
                }
            })
        }
        holder.binding.imageView2.setOnClickListener {
            if (holder.isPlaying) {
                holder.exoPlayer?.pause()
                holder.isPlaying = false

            } else {
                if (holder.audioEnded) {
                    holder.exoPlayer?.seekTo(0)
                    holder.audioEnded = false
                }
                holder.exoPlayer?.play()
                holder.isPlaying = true

            }
        }
    }
    override fun onViewRecycled(holder: ViewHolder) {
        super.onViewRecycled(holder)
        holder.exoPlayer?.release()
        holder.exoPlayer = null
    }
}