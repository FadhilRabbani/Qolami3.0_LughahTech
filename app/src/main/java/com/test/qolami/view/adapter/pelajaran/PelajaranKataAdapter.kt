package com.test.qolami.view.adapter.pelajaran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.qolami.R
import com.test.qolami.databinding.DataPelajaranHurufBinding
import com.test.qolami.databinding.DataPelajaranKataBinding
import com.test.qolami.view.pelajaran.data.DataPelajaranHuruf
import com.test.qolami.view.pelajaran.data.DataPelajaranKata

class PelajaranKataAdapter(var dataKata: ArrayList<DataPelajaranKata>): RecyclerView.Adapter<PelajaranKataAdapter.ViewHolder>() {
    class ViewHolder(var binding: DataPelajaranKataBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = DataPelajaranKataBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataKata.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView).load(dataKata[position].logo).into(holder.binding.imageLogoPelajaran)
        holder.binding.textPelajaran.text = dataKata[position].pelajaran
        holder.binding.textPenjelasan.text = dataKata[position].penjelasan
        holder.binding.btnDetil.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pelajaran", dataKata[position].pelajaran)
            it.findNavController().navigate(R.id.action_pelajaranHurufFragment_to_detailPelajaranFragment, bundle)
        }
    }
}