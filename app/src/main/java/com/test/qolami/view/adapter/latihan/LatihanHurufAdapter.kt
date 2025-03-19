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


class LatihanHurufAdapter (var dataHuruf: ArrayList<DataLatihanHuruf>):RecyclerView.Adapter<LatihanHurufAdapter.ViewHolder>() {
    class ViewHolder(var binding: DataLatihanHurufBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = DataLatihanHurufBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataHuruf.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var angka = position

        Glide.with(holder.itemView).load(dataHuruf[position].logo).into(holder.binding.imageLogoLatihan)
        holder.binding.textLatihan.text = dataHuruf[position].latihan
        holder.binding.textPenjelasan.text = dataHuruf[position].penjelasan
        holder.binding.btnDetil.setOnClickListener {
            angka++
            val bundle = Bundle()
            bundle.putString("latihan", dataHuruf[position].latihan + " " + angka)
            it.findNavController()
                .navigate(R.id.action_fragmentLatihanHuruf_to_fragmentDetailLatihanHuruf, bundle)
        }
    }

}