package com.test.qolami.view.adapter.latihan

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.qolami.R
import com.test.qolami.databinding.DataLatihanHurufBinding
import com.test.qolami.view.latihan.DataLatihanHuruf
import com.test.qolami.view.latihan.LatihanItem

class LatihanHurufAdapter (var dataHuruf: ArrayList<DataLatihanHuruf>):RecyclerView.Adapter<LatihanHurufAdapter.ViewHolder>() {
    class ViewHolder(var binding: DataLatihanHurufBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =
            DataLatihanHurufBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataHuruf.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataHuruf[position]

        Glide.with(holder.itemView).load(item.logo).into(holder.binding.imageLogoLatihan)
        holder.binding.textLatihan.text = item.latihan
        holder.binding.textPenjelasan.text = item.penjelasan

        holder.binding.btnDetil.setOnClickListener {
            val bundle = Bundle().apply {
                putInt("latihanId", item.id)
                putString("judulLatihan", item.latihan)
            }
            it.findNavController().navigate(R.id.action_fragmentLatihanHuruf_to_fragmentDetailLatihanHuruf, bundle)
        }
    }
}
