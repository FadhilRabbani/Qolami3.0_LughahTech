package com.test.qolami.view.adapter.pelajaran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.qolami.R
import com.test.qolami.databinding.DataPelajaran1Binding
import com.test.qolami.view.pelajaran.data.DataMenuPelajaran1Huruf

class PelajaranHuruf7Adapter (var listHurufDammahtain: ArrayList<DataMenuPelajaran1Huruf>): RecyclerView.Adapter<PelajaranHuruf7Adapter.ViewHolder>() {
    class ViewHolder (var binding: DataPelajaran1Binding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = DataPelajaran1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHurufDammahtain.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView).load(listHurufDammahtain[position].gambarPelajaran).into(holder.binding.imageView2)
        var grid = position / 5
        val color = when(grid % 6){
            0 -> R.color.choklat
            1 -> R.color.oren
            3 -> R.color.biru_tua
            4 -> R.color.warna_hijau_tua
            5 -> R.color.ungu
            else -> R.color.choklat_muda
        }
        val test = holder.itemView.context.resources.getColor(color, null)
        holder.binding.cv.setCardBackgroundColor(test)
        holder.binding.imageView2.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("id7", listHurufDammahtain[position].id)
            bundle.putString("judul", "Pelajaran 7")
            it.findNavController().navigate(R.id.action_pelajaran1Fragment_to_videoPembelajaranFragment, bundle)
        }
    }
}