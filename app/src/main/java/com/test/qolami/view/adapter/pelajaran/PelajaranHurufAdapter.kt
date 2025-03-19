package com.test.qolami.view.adapter.pelajaran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.qolami.R
import com.test.qolami.databinding.DataPelajaranHurufBinding
import com.test.qolami.view.pelajaran.data.DataPelajaranHuruf


class PelajaranHurufAdapter(var dataHuruf: ArrayList<DataPelajaranHuruf>):RecyclerView.Adapter<PelajaranHurufAdapter.ViewHolder>() {
    class ViewHolder(var binding: DataPelajaranHurufBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = DataPelajaranHurufBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataHuruf.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView).load(dataHuruf[position].logo).into(holder.binding.imageLogoPelajaran)
        holder.binding.textPelajaran.text = dataHuruf[position].pelajaran
        holder.binding.textPenjelasan.text = dataHuruf[position].penjelesan
        holder.binding.btnDetil.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("pelajaran", dataHuruf[position].pelajaran)
            it.findNavController().navigate(R.id.action_pelajaranHurufFragment_to_detailPelajaranFragment, bundle)
        }
    }

}